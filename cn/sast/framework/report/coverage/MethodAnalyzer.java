/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.coverage.InstructionsBuilder
 *  cn.sast.framework.report.coverage.MethodAnalyzer
 *  org.jacoco.core.internal.flow.IFrame
 *  org.jacoco.core.internal.flow.LabelInfo
 *  org.jacoco.core.internal.flow.MethodProbesVisitor
 *  org.objectweb.asm.Handle
 *  org.objectweb.asm.Label
 *  org.objectweb.asm.MethodVisitor
 *  org.objectweb.asm.tree.AbstractInsnNode
 *  org.objectweb.asm.tree.MethodNode
 *  org.objectweb.asm.tree.TryCatchBlockNode
 */
package cn.sast.framework.report.coverage;

import cn.sast.framework.report.coverage.InstructionsBuilder;
import java.util.ListIterator;
import org.jacoco.core.internal.flow.IFrame;
import org.jacoco.core.internal.flow.LabelInfo;
import org.jacoco.core.internal.flow.MethodProbesVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TryCatchBlockNode;

public class MethodAnalyzer
extends MethodProbesVisitor {
    private final InstructionsBuilder builder;
    private AbstractInsnNode currentNode;

    public MethodAnalyzer(InstructionsBuilder builder2) {
        super(null);
        this.builder = builder2;
    }

    public void accept(MethodNode methodNode, MethodVisitor methodVisitor) {
        methodVisitor.visitCode();
        for (TryCatchBlockNode n : methodNode.tryCatchBlocks) {
            n.accept(methodVisitor);
        }
        ListIterator listIterator = methodNode.instructions.iterator();
        while (listIterator.hasNext()) {
            AbstractInsnNode i;
            this.currentNode = i = (AbstractInsnNode)listIterator.next();
            i.accept(methodVisitor);
        }
        methodVisitor.visitEnd();
    }

    public void visitLabel(Label label) {
        this.builder.addLabel(label);
    }

    public void visitLineNumber(int line, Label start2) {
        this.builder.setCurrentLine(line);
    }

    public void visitInsn(int opcode) {
        this.builder.addInstruction(this.currentNode);
    }

    public void visitIntInsn(int opcode, int operand) {
        this.builder.addInstruction(this.currentNode);
    }

    public void visitVarInsn(int opcode, int var) {
        this.builder.addInstruction(this.currentNode);
    }

    public void visitTypeInsn(int opcode, String type) {
        this.builder.addInstruction(this.currentNode);
    }

    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        this.builder.addInstruction(this.currentNode);
    }

    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        this.builder.addInstruction(this.currentNode);
    }

    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object ... bsmArgs) {
        this.builder.addInstruction(this.currentNode);
    }

    public void visitJumpInsn(int opcode, Label label) {
        this.builder.addInstruction(this.currentNode);
        this.builder.addJump(label, 1);
    }

    public void visitLdcInsn(Object cst) {
        this.builder.addInstruction(this.currentNode);
    }

    public void visitIincInsn(int var, int increment) {
        this.builder.addInstruction(this.currentNode);
    }

    public void visitTableSwitchInsn(int min, int max, Label dflt, Label ... labels) {
        this.visitSwitchInsn(dflt, labels);
    }

    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        this.visitSwitchInsn(dflt, labels);
    }

    private void visitSwitchInsn(Label dflt, Label[] labels) {
        this.builder.addInstruction(this.currentNode);
        LabelInfo.resetDone((Label[])labels);
        int branch = 0;
        this.builder.addJump(dflt, branch);
        LabelInfo.setDone((Label)dflt);
        for (Label l : labels) {
            if (LabelInfo.isDone((Label)l)) continue;
            this.builder.addJump(l, ++branch);
            LabelInfo.setDone((Label)l);
        }
    }

    public void visitMultiANewArrayInsn(String desc, int dims) {
        this.builder.addInstruction(this.currentNode);
    }

    public void visitProbe(int probeId) {
        this.builder.addProbe(probeId, 0);
        this.builder.noSuccessor();
    }

    public void visitJumpInsnWithProbe(int opcode, Label label, int probeId, IFrame frame) {
        this.builder.addInstruction(this.currentNode);
        this.builder.addProbe(probeId, 1);
    }

    public void visitInsnWithProbe(int opcode, int probeId) {
        this.builder.addInstruction(this.currentNode);
        this.builder.addProbe(probeId, 0);
    }

    public void visitTableSwitchInsnWithProbes(int min, int max, Label dflt, Label[] labels, IFrame frame) {
        this.visitSwitchInsnWithProbes(dflt, labels);
    }

    public void visitLookupSwitchInsnWithProbes(Label dflt, int[] keys, Label[] labels, IFrame frame) {
        this.visitSwitchInsnWithProbes(dflt, labels);
    }

    private void visitSwitchInsnWithProbes(Label dflt, Label[] labels) {
        this.builder.addInstruction(this.currentNode);
        LabelInfo.resetDone((Label)dflt);
        LabelInfo.resetDone((Label[])labels);
        int branch = 0;
        this.visitSwitchTarget(dflt, branch);
        for (Label l : labels) {
            this.visitSwitchTarget(l, ++branch);
        }
    }

    private void visitSwitchTarget(Label label, int branch) {
        int id = LabelInfo.getProbeId((Label)label);
        if (!LabelInfo.isDone((Label)label)) {
            if (id == -1) {
                this.builder.addJump(label, branch);
            } else {
                this.builder.addProbe(id, branch);
            }
            LabelInfo.setDone((Label)label);
        }
    }
}

