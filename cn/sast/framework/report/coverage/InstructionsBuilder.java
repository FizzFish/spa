/*
 * Copyright (c) 2022, SAP SE or an SAP affiliate company. All rights reserved.
 */
package cn.sast.framework.report.coverage;

import org.jacoco.core.internal.analysis.Instruction;
import org.jacoco.core.internal.flow.LabelInfo;
import org.objectweb.asm.Label;
import org.objectweb.asm.tree.AbstractInsnNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InstructionsBuilder {
    private final boolean[] probes;
    private int currentLine = -1;
    private Instruction currentInsn;
    private final Map<AbstractInsnNode, Instruction> instructions = new HashMap<>();
    private final List<Label> currentLabel = new ArrayList<>(2);
    private final List<Jump> jumps = new ArrayList<>();

    public InstructionsBuilder(boolean[] probes) {
        this.probes = probes;
    }

    public void setCurrentLine(int line) {
        this.currentLine = line;
    }

    public void addLabel(Label label) {
        currentLabel.add(label);
        if (!LabelInfo.isSuccessor(label)) {
            noSuccessor();
        }
    }

    public void addInstruction(AbstractInsnNode node) {
        Instruction insn = new Instruction(currentLine);
        
        if (!currentLabel.isEmpty()) {
            for (int i = currentLabel.size() - 1; i >= 0; i--) {
                LabelInfo.setInstruction(currentLabel.get(i), insn);
            }
            currentLabel.clear();
        }

        if (currentInsn != null) {
            currentInsn.addBranch(insn, 0);
        }
        
        currentInsn = insn;
        instructions.put(node, insn);
    }

    public void noSuccessor() {
        currentInsn = null;
    }

    public void addJump(Label target, int branch) {
        jumps.add(new Jump(currentInsn, target, branch));
    }

    public void addProbe(int probeId, int branch) {
        boolean executed = probes != null && probes[probeId];
        currentInsn.addBranch(executed, branch);
    }

    public Map<AbstractInsnNode, Instruction> getInstructions() {
        jumps.forEach(Jump::wire);
        return instructions;
    }

    public static final class Jump {
        private final Instruction source;
        private final Label target;
        private final int branch;

        public Jump(Instruction source, Label target, int branch) {
            this.source = source;
            this.target = target;
            this.branch = branch;
        }

        public void wire() {
            Instruction targetInsn = LabelInfo.getInstruction(target);
            if (source != null && targetInsn != null) {
                source.addBranch(targetInsn, branch);
            }
        }
    }
}