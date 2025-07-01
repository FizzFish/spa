/*
 * Copyright (c) 2022, SAP SE or an SAP affiliate company. All rights reserved.
 */
package cn.sast.framework.report.coverage;

import cn.sast.framework.report.coverage.InstructionsBuilder;
import org.jacoco.core.internal.flow.IFrame;
import org.jacoco.core.internal.flow.LabelInfo;
import org.jacoco.core.internal.flow.MethodProbesVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TryCatchBlockNode;

import java.util.ListIterator;

public class MethodAnalyzer extends MethodProbesVisitor {
    private final InstructionsBuilder builder;
    private AbstractInsnNode currentNode;

    public MethodAnalyzer(InstructionsBuilder builder) {
        super(null);
        this.builder = builder;
    }

    public void accept(MethodNode methodNode, MethodVisitor methodVisitor) {
        methodVisitor.visitCode();
        for (TryCatchBlockNode n : methodNode.tryCatchBlocks) {
            n.accept(methodVisitor);
        }

        ListIterator<AbstractInsnNode> iterator = methodNode.instructions.iterator();
        while (iterator.hasNext()) {
            this.currentNode = iterator.next();
            this.currentNode.accept(methodVisitor);
        }
        methodVisitor.visitEnd();
    }

    @Override
    public void visitLabel(Label label) {
        builder.addLabel(label);
    }

    @Override
    public void visitLineNumber(int line, Label start) {
        builder.setCurrentLine(line);
    }

    @Override
    public void visitInsn(int opcode) {
        builder.addInstruction(currentNode);
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        builder.addInstruction(currentNode);
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        builder.addInstruction(currentNode);
    }

    @Override
    public void visitTypeInsn(int opcode, String type) {
        builder.addInstruction(currentNode);
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        builder.addInstruction(currentNode);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        builder.addInstruction(currentNode);
    }

    @Override
    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
        builder.addInstruction(currentNode);
    }

    @Override
    public void visitJumpInsn(int opcode, Label label) {
        builder.addInstruction(currentNode);
        builder.addJump(label, 1);
    }

    @Override
    public void visitLdcInsn(Object cst) {
        builder.addInstruction(currentNode);
    }

    @Override
    public void visitIincInsn(int var, int increment) {
        builder.addInstruction(currentNode);
    }

    @Override
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        visitSwitchInsn(dflt, labels);
    }

    @Override
    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        visitSwitchInsn(dflt, labels);
    }

    private void visitSwitchInsn(Label dflt, Label[] labels) {
        builder.addInstruction(currentNode);
        LabelInfo.resetDone(labels);
        int branch = 0;
        builder.addJump(dflt, branch);
        LabelInfo.setDone(dflt);
        
        for (Label l : labels) {
            if (!LabelInfo.isDone(l)) {
                builder.addJump(l, ++branch);
                LabelInfo.setDone(l);
            }
        }
    }

    @Override
    public void visitMultiANewArrayInsn(String desc, int dims) {
        builder.addInstruction(currentNode);
    }

    @Override
    public void visitProbe(int probeId) {
        builder.addProbe(probeId, 0);
        builder.noSuccessor();
    }

    @Override
    public void visitJumpInsnWithProbe(int opcode, Label label, int probeId, IFrame frame) {
        builder.addInstruction(currentNode);
        builder.addProbe(probeId, 1);
    }

    @Override
    public void visitInsnWithProbe(int opcode, int probeId) {
        builder.addInstruction(currentNode);
        builder.addProbe(probeId, 0);
    }

    @Override
    public void visitTableSwitchInsnWithProbes(int min, int max, Label dflt, Label[] labels, IFrame frame) {
        visitSwitchInsnWithProbes(dflt, labels);
    }

    @Override
    public void visitLookupSwitchInsnWithProbes(Label dflt, int[] keys, Label[] labels, IFrame frame) {
        visitSwitchInsnWithProbes(dflt, labels);
    }

    private void visitSwitchInsnWithProbes(Label dflt, Label[] labels) {
        builder.addInstruction(currentNode);
        LabelInfo.resetDone(dflt);
        LabelInfo.resetDone(labels);
        int branch = 0;
        visitSwitchTarget(dflt, branch);
        
        for (Label l : labels) {
            visitSwitchTarget(l, ++branch);
        }
    }

    private void visitSwitchTarget(Label label, int branch) {
        if (!LabelInfo.isDone(label)) {
            int id = LabelInfo.getProbeId(label);
            if (id == -1) {
                builder.addJump(label, branch);
            } else {
                builder.addProbe(id, branch);
            }
            LabelInfo.setDone(label);
        }
    }
}