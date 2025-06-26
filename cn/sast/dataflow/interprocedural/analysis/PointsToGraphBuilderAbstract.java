/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CallStackContext
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IData$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IFact
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IHeapKVData
 *  cn.sast.dataflow.interprocedural.analysis.IHeapKVData$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.IIFact
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.interprocedural.analysis.IVGlobal
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.analysis.PointsToGraphAbstract
 *  cn.sast.dataflow.interprocedural.analysis.PointsToGraphBuilderAbstract
 *  cn.sast.dataflow.interprocedural.analysis.ReferenceContext$PTG
 *  cn.sast.dataflow.interprocedural.analysis.ReferenceContext$Slot
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapKV
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV
 *  cn.sast.dataflow.interprocedural.check.BuiltInModelT
 *  cn.sast.dataflow.interprocedural.check.heapimpl.FieldHeapKV
 *  cn.sast.dataflow.util.Printer
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.collections.immutable.ImmutableSet
 *  kotlinx.collections.immutable.PersistentMap
 *  kotlinx.collections.immutable.PersistentMap$Builder
 *  kotlinx.collections.immutable.PersistentSet$Builder
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.ArrayType
 *  soot.G
 *  soot.IntType
 *  soot.Local
 *  soot.RefType
 *  soot.SootMethod
 *  soot.Type
 *  soot.Value
 *  soot.jimple.Constant
 *  soot.jimple.IntConstant
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CallStackContext;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IIFact;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.IVGlobal;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.PointsToGraphAbstract;
import cn.sast.dataflow.interprocedural.analysis.ReferenceContext;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapKV;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import cn.sast.dataflow.interprocedural.check.BuiltInModelT;
import cn.sast.dataflow.interprocedural.check.heapimpl.FieldHeapKV;
import cn.sast.dataflow.util.Printer;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableSet;
import kotlinx.collections.immutable.PersistentMap;
import kotlinx.collections.immutable.PersistentSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;
import soot.G;
import soot.IntType;
import soot.Local;
import soot.RefType;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.jimple.Constant;
import soot.jimple.IntConstant;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00e6\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0085\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\r\u0012(\u0010\u000f\u001a$\u0012\u0004\u0012\u00028\u0000\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u00100\r\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0002H\u0016J.\u0010-\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010/\u001a\u000200H\u0016J<\u00101\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010)\u001a\u00020*2\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u0000032\n\u00104\u001a\u00060\u0002j\u0002`\u00112\b\u00105\u001a\u0004\u0018\u00010\u0002H&J\u0010\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020\u0002H\u0016J2\u00108\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00122\u0006\u0010)\u001a\u00020*2\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u0000032\n\u00104\u001a\u00060\u0002j\u0002`\u0011H&J\u00ac\u0001\u0010:\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\"\b\b\u0001\u0010;*\u00020\u00022\u0006\u0010)\u001a\u00020*2\n\u00104\u001a\u00060\u0002j\u0002`\u00112(\u0010<\u001a$\u0012\u0004\u0012\u00028\u0000\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u00100\u00102\u0006\u0010,\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u0001H;2\u0006\u00101\u001a\u00020025\u0010=\u001a1\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u000003\u00a2\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H;\u0012\u0004\u0012\u00028\u0000\u0018\u00010B0>\u00a2\u0006\u0002\u0010CJX\u0010D\u001a\u000200\"\u0006\b\u0001\u0010E\u0018\u00012\n\u00104\u001a\u00060\u0002j\u0002`\u00112\u0006\u0010,\u001a\u00020\u000221\b\u0004\u0010F\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u000003\u00a2\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(H\u0012\u0006\u0012\u0004\u0018\u0001HE\u0012\u0004\u0012\u00020(0GH\u0082\bJ\u00ba\u0001\u0010I\u001a\u000200\"\b\b\u0001\u0010;*\u00020\u00022\u0006\u0010)\u001a\u00020*2\n\u00104\u001a\u00060\u0002j\u0002`\u00112(\u0010<\u001a$\u0012\u0004\u0012\u00028\u0000\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u00100\u00102\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u0000032\b\u00105\u001a\u0004\u0018\u0001H;2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010/\u001a\u00020025\u0010=\u001a1\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u000003\u00a2\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H;\u0012\u0004\u0012\u00028\u0000\u0018\u00010B0>\u00a2\u0006\u0002\u0010KJ\u0016\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000M2\u0006\u0010N\u001a\u00020OH&J<\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000Q2\u0006\u0010)\u001a\u00020*2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010N\u001a\u00020R2\u000e\u0010S\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000eH&J<\u0010T\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\f\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010V\u001a\u00020W2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010/\u001a\u000200J6\u0010T\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010V\u001a\u00020W2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010/\u001a\u000200J0\u0010X\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010V\u001a\u00020W2\u0006\u0010,\u001a\u00020\u00022\u0006\u0010/\u001a\u000200H\u0016J.\u0010Y\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010V\u001a\u00020W2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016J\u0010\u0010Z\u001a\u00020(2\u0006\u0010+\u001a\u00020\u0002H\u0016J0\u0010[\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00022\u0006\u0010V\u001a\u00020W2\u0006\u0010\\\u001a\u000200H\u0016J\b\u0010]\u001a\u00020^H\u0016J\u0016\u0010_\u001a\u00020(2\f\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00000aH\u0016J\b\u0010b\u001a\u00020(H\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020cH\u0016J\u0010\u0010d\u001a\u00020(2\u0006\u0010e\u001a\u00020\u0015H\u0016J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150fH\u0016J\u0018\u0010g\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u00107\u001a\u00020\u0002H\u0016J\b\u0010h\u001a\u000200H\u0016J\b\u0010i\u001a\u000200H\u0016J\u0018\u0010j\u001a\u0004\u0018\u00010k2\f\u0010l\u001a\b\u0012\u0004\u0012\u00028\u000003H&J7\u0010m\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u000003\u00a2\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010Q0>2\u0006\u0010)\u001a\u00020*J/\u0010n\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u000003\u00a2\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010M0>J8\u0010o\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\b\u0010p\u001a\u0004\u0018\u00010q2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010/\u001a\u000200J0\u0010r\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010p\u001a\u00020q2\u0006\u0010,\u001a\u00020q2\u0006\u0010s\u001a\u00020kH\u0016J0\u0010t\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\b\u0010p\u001a\u0004\u0018\u00010q2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016J\u001a\u0010u\u001a\n\u0012\u0004\u0012\u00020w\u0018\u00010v2\b\u0010p\u001a\u0004\u0018\u00010qH\u0002J*\u0010x\u001a\u0002002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00022\b\u0010p\u001a\u0004\u0018\u00010qH\u0016J*\u0010x\u001a\u0002002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020q2\b\u0010p\u001a\u0004\u0018\u00010qH\u0016J$\u0010y\u001a\u00020(2\f\u0010l\u001a\b\u0012\u0004\u0012\u00028\u0000032\f\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0002J8\u0010{\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010V\u001a\u00020W2\u0006\u0010,\u001a\u00020q2\u0006\u0010s\u001a\u00020k2\u0006\u0010/\u001a\u000200H\u0016J(\u0010|\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020q2\u0006\u0010s\u001a\u00020kH\u0016J6\u0010}\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010N\u001a\u00020R2\u0006\u0010~\u001a\u00020qH\u0016J*\u0010\u007f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00122\u0006\u0010A\u001a\u00028\u00002\n\u00104\u001a\u00060\u0002j\u0002`\u0011H\u0016\u00a2\u0006\u0003\u0010\u0080\u0001J<\u0010\u0081\u0001\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010A\u001a\u00028\u00002\n\u00104\u001a\u00060\u0002j\u0002`\u00112\u000f\u0010\u0082\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012H\u0016\u00a2\u0006\u0003\u0010\u0083\u0001J!\u0010\u0084\u0001\u001a\u00020(2\u0007\u0010\u0085\u0001\u001a\u00028\u00002\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0016\u00a2\u0006\u0003\u0010\u0087\u0001J\u0017\u0010\u0088\u0001\u001a\u00020(2\u000e\u0010\u0089\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u008a\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\b\u001a\u00020\tX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R&\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\rX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R6\u0010\u000f\u001a$\u0012\u0004\u0012\u00028\u0000\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u00100\rX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&\u00a8\u0006\u008b\u0001"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/PointsToGraphBuilderAbstract;", "V", "", "Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "orig", "Lcn/sast/dataflow/interprocedural/analysis/PointsToGraphAbstract;", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "vg", "Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;", "callStack", "Lcn/sast/dataflow/interprocedural/analysis/CallStackContext;", "slots", "Lkotlinx/collections/immutable/PersistentMap$Builder;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "heap", "Lkotlinx/collections/immutable/PersistentMap;", "Lcn/sast/dataflow/interprocedural/check/ModelT;", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "calledMethods", "Lkotlinx/collections/immutable/PersistentSet$Builder;", "Lsoot/SootMethod;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/PointsToGraphAbstract;Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;Lcn/sast/dataflow/interprocedural/analysis/CallStackContext;Lkotlinx/collections/immutable/PersistentMap$Builder;Lkotlinx/collections/immutable/PersistentMap$Builder;Lkotlinx/collections/immutable/PersistentSet$Builder;)V", "getOrig", "()Lcn/sast/dataflow/interprocedural/analysis/PointsToGraphAbstract;", "getHf", "()Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "getVg", "()Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;", "getCallStack", "()Lcn/sast/dataflow/interprocedural/analysis/CallStackContext;", "setCallStack", "(Lcn/sast/dataflow/interprocedural/analysis/CallStackContext;)V", "getSlots", "()Lkotlinx/collections/immutable/PersistentMap$Builder;", "getHeap", "getCalledMethods", "()Lkotlinx/collections/immutable/PersistentSet$Builder;", "assignLocal", "", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "lhs", "rhs", "assignNewExpr", "allocSite", "append", "", "newSummary", "src", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "mt", "key", "kill", "slot", "getConstantPoolObjectData", "cv", "getHeapKVData", "K", "oldHeap", "emptyIData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "v", "Lcn/sast/dataflow/interprocedural/analysis/IHeapKVData;", "(Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;Ljava/lang/Object;Lkotlinx/collections/immutable/PersistentMap;Ljava/lang/Object;Ljava/lang/Object;ZLkotlin/jvm/functions/Function1;)Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "getHeapData", "DT", "transform", "Lkotlin/Function2;", "rhsV", "setHeapKVData", "update", "(Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;Ljava/lang/Object;Lkotlinx/collections/immutable/PersistentMap;Lcn/sast/dataflow/interprocedural/analysis/CompanionV;Ljava/lang/Object;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;ZLkotlin/jvm/functions/Function1;)Z", "getEmptyFieldSpace", "Lcn/sast/dataflow/interprocedural/check/heapimpl/FieldHeapKV;", "type", "Lsoot/RefType;", "getEmptyArraySpace", "Lcn/sast/dataflow/interprocedural/analysis/heapimpl/ArrayHeapKV;", "Lsoot/ArrayType;", "arrayLength", "assignField", "lhsPointees", "field", "Lcn/sast/dataflow/interprocedural/analysis/JFieldType;", "setField", "setFieldNew", "summarizeTargetFields", "getField", "newSummaryField", "toString", "", "union", "that", "Lcn/sast/dataflow/interprocedural/analysis/IFact;", "gc", "", "addCalledMethod", "sm", "Lkotlinx/collections/immutable/ImmutableSet;", "getTargetsUnsafe", "isBottom", "isTop", "getType", "Lsoot/Type;", "value", "emptyArrayFx", "emptyFieldFx", "setArray", "index", "Lsoot/Value;", "setArraySootValue", "valueType", "setArrayValueNew", "getAllIndex", "", "", "getArrayValue", "setIData", "bindData", "assignFieldSootValue", "assignLocalSootValue", "assignNewArray", "size", "getValueData", "(Ljava/lang/Object;Ljava/lang/Object;)Lcn/sast/dataflow/interprocedural/analysis/IData;", "setValueData", "data", "(Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;Ljava/lang/Object;Ljava/lang/Object;Lcn/sast/dataflow/interprocedural/analysis/IData;)V", "copyValueData", "from", "to", "(Ljava/lang/Object;Ljava/lang/Object;)V", "apply", "re", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nPointsToGraphAbstract.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PointsToGraphAbstract.kt\ncn/sast/dataflow/interprocedural/analysis/PointsToGraphBuilderAbstract\n+ 2 PointsToGraphAbstract.kt\ncn/sast/dataflow/interprocedural/analysis/PointsToGraphAbstractKt\n*L\n1#1,1045:1\n119#2,3:1046\n119#2,3:1049\n119#2,3:1052\n119#2,3:1055\n119#2,3:1058\n*S KotlinDebug\n*F\n+ 1 PointsToGraphAbstract.kt\ncn/sast/dataflow/interprocedural/analysis/PointsToGraphBuilderAbstract\n*L\n580#1:1046,3\n610#1:1049,3\n650#1:1052,3\n865#1:1055,3\n979#1:1058,3\n*E\n"})
public abstract class PointsToGraphBuilderAbstract<V>
implements IFact.Builder<V> {
    @NotNull
    private final PointsToGraphAbstract<V> orig;
    @NotNull
    private final AbstractHeapFactory<V> hf;
    @NotNull
    private final IVGlobal vg;
    @NotNull
    private CallStackContext callStack;
    @NotNull
    private final PersistentMap.Builder<Object, IHeapValues<V>> slots;
    @NotNull
    private final PersistentMap.Builder<V, PersistentMap<Object, IData<V>>> heap;
    @NotNull
    private final PersistentSet.Builder<SootMethod> calledMethods;

    public PointsToGraphBuilderAbstract(@NotNull PointsToGraphAbstract<V> orig, @NotNull AbstractHeapFactory<V> hf, @NotNull IVGlobal vg, @NotNull CallStackContext callStack, @NotNull PersistentMap.Builder<Object, IHeapValues<V>> slots, @NotNull PersistentMap.Builder<V, PersistentMap<Object, IData<V>>> heap, @NotNull PersistentSet.Builder<SootMethod> calledMethods) {
        Intrinsics.checkNotNullParameter(orig, (String)"orig");
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)vg, (String)"vg");
        Intrinsics.checkNotNullParameter((Object)callStack, (String)"callStack");
        Intrinsics.checkNotNullParameter(slots, (String)"slots");
        Intrinsics.checkNotNullParameter(heap, (String)"heap");
        Intrinsics.checkNotNullParameter(calledMethods, (String)"calledMethods");
        this.orig = orig;
        this.hf = hf;
        this.vg = vg;
        this.callStack = callStack;
        this.slots = slots;
        this.heap = heap;
        this.calledMethods = calledMethods;
    }

    @NotNull
    public final PointsToGraphAbstract<V> getOrig() {
        return this.orig;
    }

    @NotNull
    public AbstractHeapFactory<V> getHf() {
        return this.hf;
    }

    @NotNull
    protected final IVGlobal getVg() {
        return this.vg;
    }

    @NotNull
    public CallStackContext getCallStack() {
        return this.callStack;
    }

    public void setCallStack(@NotNull CallStackContext callStackContext) {
        Intrinsics.checkNotNullParameter((Object)callStackContext, (String)"<set-?>");
        this.callStack = callStackContext;
    }

    @NotNull
    protected final PersistentMap.Builder<Object, IHeapValues<V>> getSlots() {
        return this.slots;
    }

    @NotNull
    protected final PersistentMap.Builder<V, PersistentMap<Object, IData<V>>> getHeap() {
        return this.heap;
    }

    @NotNull
    public final PersistentSet.Builder<SootMethod> getCalledMethods() {
        return this.calledMethods;
    }

    public void assignLocal(@NotNull HeapValuesEnv env, @NotNull Object lhs, @NotNull Object rhs) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)lhs, (String)"lhs");
        Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
        IHeapValues rhsValue = (IHeapValues)this.slots.get(rhs);
        if (rhsValue == null || rhsValue.isEmpty()) {
            IIFact.Companion.getLogger().debug(() -> PointsToGraphBuilderAbstract.assignLocal$lambda$0(env, rhs, rhsValue));
            IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)((IFact.Builder)this), (HeapValuesEnv)env, (Object)lhs, (IHeapValues)this.getHf().empty(), (boolean)false, (int)8, null);
        } else {
            IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)((IFact.Builder)this), (HeapValuesEnv)env, (Object)lhs, (IHeapValues)rhsValue, (boolean)false, (int)8, null);
        }
    }

    public void assignNewExpr(@NotNull HeapValuesEnv env, @NotNull Object lhs, @NotNull IHeapValues<V> allocSite, boolean append) {
        IHeapValues iHeapValues;
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)lhs, (String)"lhs");
        Intrinsics.checkNotNullParameter(allocSite, (String)"allocSite");
        if (append) {
            IHeapValues iHeapValues2 = (IHeapValues)this.slots.get(lhs);
            if (iHeapValues2 == null) {
                iHeapValues2 = this.getHf().empty();
            }
            iHeapValues = allocSite.plus(iHeapValues2);
        } else {
            iHeapValues = allocSite;
        }
        IHeapValues values = iHeapValues;
        ((Map)this.slots).put(lhs, this.getHf().push(env, values).assignLocal(lhs, values).pop());
        if (values.isEmpty()) {
            IIFact.Companion.getLogger().debug(() -> PointsToGraphBuilderAbstract.assignNewExpr$lambda$1(env));
        }
    }

    @Nullable
    public abstract IHeapValues<V> newSummary(@NotNull HeapValuesEnv var1, @NotNull CompanionV<V> var2, @NotNull Object var3, @Nullable Object var4);

    public void kill(@NotNull Object slot) {
        Intrinsics.checkNotNullParameter((Object)slot, (String)"slot");
        this.slots.remove(slot);
    }

    @Nullable
    public abstract IData<V> getConstantPoolObjectData(@NotNull HeapValuesEnv var1, @NotNull CompanionV<V> var2, @NotNull Object var3);

    @Nullable
    public final <K> IHeapValues<V> getHeapKVData(@NotNull HeapValuesEnv env, @NotNull Object mt, @NotNull PersistentMap<V, ? extends PersistentMap<Object, ? extends IData<V>>> oldHeap, @NotNull Object rhs, @Nullable K key2, boolean newSummary, @NotNull Function1<? super CompanionV<V>, ? extends IHeapKVData<K, V>> emptyIData) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)mt, (String)"mt");
        Intrinsics.checkNotNullParameter(oldHeap, (String)"oldHeap");
        Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
        Intrinsics.checkNotNullParameter(emptyIData, (String)"emptyIData");
        IHeapValues iHeapValues = this.getTargetsUnsafe(rhs);
        if (iHeapValues == null) {
            return null;
        }
        IHeapValues rhsPointees = iHeapValues;
        IHeapValues.Builder rhsValue = this.getHf().empty().builder();
        IHeapValues $this$foreach$iv = rhsPointees;
        boolean $i$f$foreach = false;
        Iterator iterator2 = $this$foreach$iv.iterator();
        while (iterator2.hasNext()) {
            IHeapValues it;
            IHeapValues targets;
            IHeapKVData edges;
            CompanionV e$iv;
            CompanionV o = e$iv = (CompanionV)iterator2.next();
            boolean bl = false;
            PersistentMap heapData = (PersistentMap)this.heap.get(o.getValue());
            PersistentMap persistentMap = heapData;
            if (persistentMap == null || (persistentMap = (IData)persistentMap.get(mt)) == null) {
                persistentMap = this.getConstantPoolObjectData(env, o, mt);
            }
            if ((edges = (IHeapKVData)persistentMap) == null) {
                IIFact.Companion.getLogger().debug(() -> PointsToGraphBuilderAbstract.getHeapKVData$lambda$4$lambda$2(mt, o, key2));
            }
            IHeapKVData iHeapKVData = edges;
            IHeapValues iHeapValues2 = targets = iHeapKVData != null ? iHeapKVData.get((IHeapValuesFactory)this.getHf(), key2) : null;
            if (targets != null && targets.isNotEmpty()) {
                rhsValue.add(this.getHf().push(env, targets).getKVValue(mt, o, key2).pop());
                continue;
            }
            if (!newSummary) continue;
            if (this.newSummary(env, o, mt, key2) == null) continue;
            boolean bl2 = false;
            if (!this.setHeapKVData(env, mt, oldHeap, o, key2, it, false, emptyIData)) continue;
            rhsValue.add(this.getHf().push(env, it).getKVValue(mt, o, key2).pop());
        }
        return rhsValue.build();
    }

    private final /* synthetic */ <DT> boolean getHeapData(Object mt, Object rhs, Function2<? super CompanionV<V>, ? super DT, Unit> transform) {
        IHeapValues rhsPointers;
        boolean $i$f$getHeapData = false;
        IHeapValues iHeapValues = (IHeapValues)this.slots.get(rhs);
        if (iHeapValues == null) {
            return false;
        }
        IHeapValues $this$foreach$iv = rhsPointers = iHeapValues;
        boolean $i$f$foreach = false;
        Iterator iterator2 = $this$foreach$iv.iterator();
        while (iterator2.hasNext()) {
            PersistentMap heapData;
            CompanionV e$iv;
            CompanionV o = e$iv = (CompanionV)iterator2.next();
            boolean bl = false;
            PersistentMap persistentMap = heapData = (PersistentMap)this.heap.get(o.getValue());
            IData iData = persistentMap != null ? (IData)persistentMap.get(mt) : null;
            Intrinsics.reifiedOperationMarker((int)1, (String)"DT?");
            Object data = iData;
            transform.invoke((Object)o, data);
        }
        return true;
    }

    public final <K> boolean setHeapKVData(@NotNull HeapValuesEnv env, @NotNull Object mt, @NotNull PersistentMap<V, ? extends PersistentMap<Object, ? extends IData<V>>> oldHeap, @NotNull CompanionV<V> lhs, @Nullable K key2, @Nullable IHeapValues<V> update2, boolean append, @NotNull Function1<? super CompanionV<V>, ? extends IHeapKVData<K, V>> emptyIData) {
        PersistentMap oldData;
        IData iData;
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)mt, (String)"mt");
        Intrinsics.checkNotNullParameter(oldHeap, (String)"oldHeap");
        Intrinsics.checkNotNullParameter(lhs, (String)"lhs");
        Intrinsics.checkNotNullParameter(emptyIData, (String)"emptyIData");
        PersistentMap persistentMap = (PersistentMap)oldHeap.get(lhs.getValue());
        if (persistentMap == null) {
            persistentMap = ExtensionsKt.persistentHashMapOf();
        }
        if ((iData = (IData)(oldData = persistentMap).get(mt)) == null) {
            IHeapKVData iHeapKVData = (IHeapKVData)emptyIData.invoke(lhs);
            if (iHeapKVData != null) {
                iData = (IData)iHeapKVData;
            } else {
                return false;
            }
        }
        IHeapKVData oldKV = (IHeapKVData)iData;
        IHeapKVData.Builder bdr = oldKV.builder();
        if (update2 == null) {
            bdr.set((IHeapValuesFactory)this.getHf(), env, key2, update2, append);
        } else {
            IHeapValues update22 = this.getHf().push(env, update2).setKVValue(mt, lhs, key2).pop();
            bdr.set((IHeapValuesFactory)this.getHf(), env, key2, update22, append);
        }
        IData newEdges = bdr.build();
        if (newEdges != oldKV) {
            ((Map)this.heap).put(lhs.getValue(), oldData.put(mt, (Object)newEdges));
        }
        return true;
    }

    @NotNull
    public abstract FieldHeapKV<V> getEmptyFieldSpace(@NotNull RefType var1);

    @NotNull
    public abstract ArrayHeapKV<V> getEmptyArraySpace(@NotNull HeapValuesEnv var1, @NotNull IHeapValues<V> var2, @NotNull ArrayType var3, @Nullable IHeapValues<V> var4);

    public final void assignField(@NotNull HeapValuesEnv env, @NotNull IHeapValues<V> lhsPointees, @NotNull JFieldType field, @Nullable IHeapValues<V> update2, boolean append) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(lhsPointees, (String)"lhsPointees");
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        PersistentMap oldHeap = this.heap.build();
        boolean finalAppend = append || !lhsPointees.isSingle();
        IHeapValues<V> $this$foreach$iv = lhsPointees;
        boolean $i$f$foreach = false;
        Iterator iterator2 = $this$foreach$iv.iterator();
        while (iterator2.hasNext()) {
            CompanionV e$iv;
            CompanionV lhsV = e$iv = (CompanionV)iterator2.next();
            boolean bl = false;
            this.setHeapKVData(env, (Object)BuiltInModelT.Field, oldHeap, lhsV, (Object)field, update2, finalAppend, this.emptyFieldFx());
        }
    }

    public final void assignField(@NotNull HeapValuesEnv env, @NotNull Object lhs, @NotNull JFieldType field, @Nullable IHeapValues<V> update2, boolean append) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)lhs, (String)"lhs");
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        IHeapValues iHeapValues = (IHeapValues)this.slots.get(lhs);
        if (iHeapValues == null) {
            return;
        }
        IHeapValues lhsPointees = iHeapValues;
        this.assignField(env, lhsPointees, field, update2, append);
    }

    public void setField(@NotNull HeapValuesEnv env, @NotNull Object lhs, @NotNull JFieldType field, @NotNull Object rhs, boolean append) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)lhs, (String)"lhs");
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
        IHeapValues rhsPointees = (IHeapValues)this.slots.get(rhs);
        this.assignField(env, lhs, field, rhsPointees, append);
    }

    public void setFieldNew(@NotNull HeapValuesEnv env, @NotNull Object lhs, @NotNull JFieldType field, @NotNull IHeapValues<V> allocSite) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)lhs, (String)"lhs");
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        Intrinsics.checkNotNullParameter(allocSite, (String)"allocSite");
        this.assignField(env, lhs, field, allocSite, false);
    }

    public void summarizeTargetFields(@NotNull Object lhs) {
        Intrinsics.checkNotNullParameter((Object)lhs, (String)"lhs");
    }

    public void getField(@NotNull HeapValuesEnv env, @NotNull Object lhs, @NotNull Object rhs, @NotNull JFieldType field, boolean newSummaryField) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)lhs, (String)"lhs");
        Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        PersistentMap oldHeap = this.heap.build();
        IHeapValues res = this.getHeapKVData(env, (Object)BuiltInModelT.Field, oldHeap, rhs, (Object)field, newSummaryField, this.emptyFieldFx());
        if (res != null) {
            IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)((IFact.Builder)this), (HeapValuesEnv)env, (Object)lhs, (IHeapValues)res, (boolean)false, (int)8, null);
        } else {
            IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)((IFact.Builder)this), (HeapValuesEnv)env, (Object)lhs, (IHeapValues)this.getHf().empty(), (boolean)false, (int)8, null);
        }
    }

    @NotNull
    public String toString() {
        CallStackContext currCtx;
        StringBuffer sb = new StringBuffer();
        CallStackContext callStackContext = currCtx = this.getCallStack();
        sb.append("call stack: " + (callStackContext != null ? Integer.valueOf(callStackContext.getDeep()) : null) + "\n");
        while (currCtx != null) {
            sb.append(currCtx);
            currCtx = currCtx.getCaller();
        }
        sb.append("\nslot:\n");
        for (Object entry : this.slots.keySet()) {
            sb.append(entry).append(" -> ").append(String.valueOf(this.slots.get(entry)));
            sb.append("\n");
        }
        sb.append("\nheap:\n");
        for (Map.Entry entry : ((Map)this.heap).entrySet()) {
            Object source = entry.getKey();
            PersistentMap data = (PersistentMap)entry.getValue();
            sb.append(Printer.Companion.node2String(source)).append(":\n");
            for (Map.Entry entry2 : ((Map)data).entrySet()) {
                Object K = entry2.getKey();
                IData values = (IData)entry2.getValue();
                sb.append("\t").append(K).append(": ").append(values).append("\n");
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        return string;
    }

    public void union(@NotNull IFact<V> that) {
        Intrinsics.checkNotNullParameter(that, (String)"that");
        if (!(that instanceof PointsToGraphAbstract)) {
            throw new IllegalArgumentException("union error of fact type: " + that.getClass() + " \n" + that);
        }
        for (Map.Entry entry : ((Map)((PointsToGraphAbstract)that).getSlots()).entrySet()) {
            Object k = entry.getKey();
            IHeapValues v = (IHeapValues)entry.getValue();
            IHeapValues iHeapValues = (IHeapValues)this.slots.get(k);
            if (iHeapValues == null) {
                iHeapValues = this.getHf().empty();
            }
            IHeapValues targets = iHeapValues;
            ((Map)this.slots).put(k, targets.plus(v));
        }
        for (Map.Entry entry : ((Map)((PointsToGraphAbstract)that).getHeap()).entrySet()) {
            Object thatSource = entry.getKey();
            PersistentMap thatData = (PersistentMap)entry.getValue();
            for (Map.Entry entry2 : ((Map)thatData).entrySet()) {
                PersistentMap pack;
                IData valuesL;
                Object kind = entry2.getKey();
                IData valuesR = (IData)entry2.getValue();
                PersistentMap persistentMap = (PersistentMap)this.heap.get(thatSource);
                if (persistentMap == null) {
                    persistentMap = ExtensionsKt.persistentHashMapOf();
                }
                if ((valuesL = (IData)(pack = persistentMap).get(kind)) == null) {
                    ((Map)this.heap).put(thatSource, pack.put(kind, (Object)valuesR));
                    continue;
                }
                if (valuesL == valuesR) continue;
                IData.Builder bdr = valuesL.builder();
                bdr.union(this.getHf(), valuesR);
                IData unionData = bdr.build();
                ((Map)this.heap).put(thatSource, pack.put(kind, (Object)unionData));
            }
        }
    }

    public void gc() {
        LinkedList workList = new LinkedList();
        for (IHeapValues nodes : this.slots.values()) {
            nodes.reference((Collection)workList);
        }
        HashSet reference = new HashSet();
        PersistentMap heapOld = this.heap.build();
        while (!workList.isEmpty()) {
            Object v = workList.remove();
            if (reference.contains(v)) continue;
            reference.add(v);
            PersistentMap persistentMap = (PersistentMap)heapOld.get(v);
            if (persistentMap == null) continue;
            Iterator iterator2 = ((Map)persistentMap).entrySet().iterator();
            while (iterator2.hasNext()) {
                IData next = (IData)iterator2.next().getValue();
                next.reference((Collection)workList);
            }
        }
        for (Object k : (ImmutableSet)heapOld.keySet()) {
            if (reference.contains(k)) continue;
            this.heap.remove(k);
        }
    }

    @NotNull
    public Set<Object> getSlots() {
        return new HashSet(this.slots.keySet());
    }

    public void addCalledMethod(@NotNull SootMethod sm) {
        Intrinsics.checkNotNullParameter((Object)sm, (String)"sm");
        this.calledMethods.add((Object)sm);
    }

    @NotNull
    public ImmutableSet<SootMethod> getCalledMethods() {
        return (ImmutableSet)this.calledMethods.build();
    }

    @Nullable
    public IHeapValues<V> getTargetsUnsafe(@NotNull Object slot) {
        Intrinsics.checkNotNullParameter((Object)slot, (String)"slot");
        Object object = slot;
        if (!(object instanceof String || object instanceof Local || object instanceof Number)) {
            IIFact.Companion.getLogger().error(() -> PointsToGraphBuilderAbstract.getTargetsUnsafe$lambda$7(slot));
        }
        return (IHeapValues)this.slots.get(slot);
    }

    public boolean isBottom() {
        return false;
    }

    public boolean isTop() {
        return false;
    }

    @Nullable
    public abstract Type getType(@NotNull CompanionV<V> var1);

    @NotNull
    public final Function1<CompanionV<V>, ArrayHeapKV<V>> emptyArrayFx(@NotNull HeapValuesEnv env) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        return arg_0 -> PointsToGraphBuilderAbstract.emptyArrayFx$lambda$8(this, env, arg_0);
    }

    @NotNull
    public final Function1<CompanionV<V>, FieldHeapKV<V>> emptyFieldFx() {
        return arg_0 -> PointsToGraphBuilderAbstract.emptyFieldFx$lambda$9(this, arg_0);
    }

    public final void setArray(@NotNull HeapValuesEnv env, @NotNull Object lhs, @Nullable Value index, @Nullable IHeapValues<V> update2, boolean append) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)lhs, (String)"lhs");
        IHeapValues iHeapValues = (IHeapValues)this.slots.get(lhs);
        if (iHeapValues == null) {
            return;
        }
        IHeapValues lhsPointees = iHeapValues;
        PersistentMap oldHeap = this.heap.build();
        Set allIndex = this.getAllIndex(index);
        boolean finalAppend = append || !lhsPointees.isSingle();
        IHeapValues $this$foreach$iv = lhsPointees;
        boolean $i$f$foreach = false;
        Iterator iterator2 = $this$foreach$iv.iterator();
        while (iterator2.hasNext()) {
            CompanionV e$iv;
            CompanionV lhsV = e$iv = (CompanionV)iterator2.next();
            boolean bl = false;
            if (allIndex == null || allIndex.isEmpty()) {
                this.setHeapKVData(env, (Object)BuiltInModelT.Array, oldHeap, lhsV, null, update2, true, this.emptyArrayFx(env));
                continue;
            }
            if (allIndex.size() == 1) {
                this.setHeapKVData(env, (Object)BuiltInModelT.Array, oldHeap, lhsV, CollectionsKt.first((Iterable)allIndex), update2, finalAppend, this.emptyArrayFx(env));
                continue;
            }
            Iterator iterator3 = allIndex.iterator();
            while (iterator3.hasNext()) {
                int idx = ((Number)iterator3.next()).intValue();
                this.setHeapKVData(env, (Object)BuiltInModelT.Array, oldHeap, lhsV, (Object)idx, update2, true, this.emptyArrayFx(env));
            }
        }
        Unit em = Unit.INSTANCE;
    }

    public void setArraySootValue(@NotNull HeapValuesEnv env, @NotNull Object lhs, @NotNull Value index, @NotNull Value rhs, @NotNull Type valueType) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)lhs, (String)"lhs");
        Intrinsics.checkNotNullParameter((Object)index, (String)"index");
        Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
        Intrinsics.checkNotNullParameter((Object)valueType, (String)"valueType");
        IHeapValues rhsPointers = this.getOfSootValue(env, rhs, valueType);
        this.setArray(env, lhs, index, rhsPointers, false);
    }

    public void setArrayValueNew(@NotNull HeapValuesEnv env, @NotNull Object lhs, @Nullable Value index, @NotNull IHeapValues<V> allocSite) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)lhs, (String)"lhs");
        Intrinsics.checkNotNullParameter(allocSite, (String)"allocSite");
        this.setArray(env, lhs, index, allocSite, false);
    }

    private final Set<Integer> getAllIndex(Value index) {
        if (index == null) {
            return null;
        }
        if (index instanceof IntConstant) {
            Object[] objectArray = new Integer[]{((IntConstant)index).value};
            return SetsKt.mutableSetOf((Object[])objectArray);
        }
        if (index instanceof Local) {
            IHeapValues iHeapValues = (IHeapValues)this.slots.get((Object)index);
            if (iHeapValues == null) {
                return null;
            }
            IHeapValues v = iHeapValues;
            return v.getAllIntValue(true);
        }
        return null;
    }

    public boolean getArrayValue(@NotNull HeapValuesEnv env, @NotNull Object lhs, @NotNull Object rhs, @Nullable Value index) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)lhs, (String)"lhs");
        Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
        IHeapValues.Builder rhsValues = this.getHf().empty().builder();
        Value value = index;
        Set allIndex = value == null ? null : this.getAllIndex(value);
        PersistentMap oldHeap = this.heap.build();
        if (allIndex == null || allIndex.isEmpty()) {
            IHeapValues iHeapValues = this.getHeapKVData(env, (Object)BuiltInModelT.Array, oldHeap, rhs, null, false, this.emptyArrayFx(env));
            if (iHeapValues != null) {
                IHeapValues iHeapValues2;
                IHeapValues it = iHeapValues2 = iHeapValues;
                boolean bl = false;
                rhsValues.add(it);
            }
        } else if (allIndex.size() == 1) {
            IHeapValues iHeapValues = this.getHeapKVData(env, (Object)BuiltInModelT.Array, oldHeap, rhs, CollectionsKt.first((Iterable)allIndex), false, this.emptyArrayFx(env));
            if (iHeapValues != null) {
                IHeapValues iHeapValues3;
                IHeapValues it = iHeapValues3 = iHeapValues;
                boolean bl = false;
                rhsValues.add(it);
            }
        } else {
            Iterator iterator2 = allIndex.iterator();
            while (iterator2.hasNext()) {
                IHeapValues iHeapValues;
                int eachIdx = ((Number)iterator2.next()).intValue();
                if (this.getHeapKVData(env, (Object)BuiltInModelT.Array, oldHeap, rhs, (Object)eachIdx, false, this.emptyArrayFx(env)) == null) continue;
                IHeapValues it = iHeapValues;
                boolean bl = false;
                rhsValues.add(it);
            }
        }
        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)((IFact.Builder)this), (HeapValuesEnv)env, (Object)lhs, (IHeapValues)rhsValues.build(), (boolean)false, (int)8, null);
        return rhsValues.isNotEmpty();
    }

    public boolean getArrayValue(@NotNull HeapValuesEnv env, @NotNull Object lhs, @NotNull Value rhs, @Nullable Value index) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)lhs, (String)"lhs");
        Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
        Value value = rhs;
        if (value instanceof Constant) {
            bl = false;
        } else if (value instanceof Local) {
            bl = this.getArrayValue(env, lhs, (Object)rhs, index);
        } else {
            throw new IllegalStateException(((Function0)() -> PointsToGraphBuilderAbstract.getArrayValue$lambda$14(rhs)).toString());
        }
        return bl;
    }

    private final void setIData(CompanionV<V> value, IData<V> bindData) {
        PersistentMap persistentMap = (PersistentMap)this.heap.get(value.getValue());
        if (persistentMap == null) {
            persistentMap = ExtensionsKt.persistentHashMapOf();
        }
        PersistentMap oldData = persistentMap;
        ((Map)this.heap).put(value.getValue(), oldData.put((Object)BuiltInModelT.Field, bindData));
    }

    public void assignFieldSootValue(@NotNull HeapValuesEnv env, @NotNull Object lhs, @NotNull JFieldType field, @NotNull Value rhs, @NotNull Type valueType, boolean append) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)lhs, (String)"lhs");
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
        Intrinsics.checkNotNullParameter((Object)valueType, (String)"valueType");
        IHeapValues value = this.getOfSootValue(env, rhs, valueType);
        this.assignField(env, lhs, field, value, append);
    }

    public void assignLocalSootValue(@NotNull HeapValuesEnv env, @NotNull Object lhs, @NotNull Value rhs, @NotNull Type valueType) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)lhs, (String)"lhs");
        Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
        Intrinsics.checkNotNullParameter((Object)valueType, (String)"valueType");
        IHeapValues value = this.getOfSootValue(env, rhs, valueType);
        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)((IFact.Builder)this), (HeapValuesEnv)env, (Object)lhs, (IHeapValues)value, (boolean)false, (int)8, null);
    }

    public void assignNewArray(@NotNull HeapValuesEnv env, @NotNull Object lhs, @NotNull IHeapValues<V> allocSite, @NotNull ArrayType type, @NotNull Value size) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)lhs, (String)"lhs");
        Intrinsics.checkNotNullParameter(allocSite, (String)"allocSite");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)size, (String)"size");
        IntType intType = G.v().soot_IntType();
        Intrinsics.checkNotNullExpressionValue((Object)intType, (String)"soot_IntType(...)");
        IHeapValues arrayLength = this.getOfSootValue(env, size, (Type)intType);
        ArrayHeapKV res = this.getEmptyArraySpace(env, allocSite, type, arrayLength);
        IHeapValues<V> $this$foreach$iv = allocSite;
        boolean $i$f$foreach = false;
        Iterator iterator2 = $this$foreach$iv.iterator();
        while (iterator2.hasNext()) {
            CompanionV e$iv;
            CompanionV it = e$iv = (CompanionV)iterator2.next();
            boolean bl = false;
            PersistentMap data = ExtensionsKt.persistentHashMapOf();
            PersistentMap persistentMap = data.put((Object)BuiltInModelT.Array, (Object)res);
            ((Map)this.heap).put(it.getValue(), persistentMap);
        }
        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)((IFact.Builder)this), (HeapValuesEnv)env, (Object)lhs, allocSite, (boolean)false, (int)8, null);
    }

    @Nullable
    public IData<V> getValueData(@NotNull V v, @NotNull Object mt) {
        Intrinsics.checkNotNullParameter(v, (String)"v");
        Intrinsics.checkNotNullParameter((Object)mt, (String)"mt");
        PersistentMap persistentMap = (PersistentMap)this.heap.get(v);
        return persistentMap != null ? (IData)persistentMap.get(mt) : null;
    }

    public void setValueData(@NotNull HeapValuesEnv env, @NotNull V v, @NotNull Object mt, @Nullable IData<V> data) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(v, (String)"v");
        Intrinsics.checkNotNullParameter((Object)mt, (String)"mt");
        if (data == null) {
            PersistentMap persistentMap;
            PersistentMap persistentMap2 = (PersistentMap)this.heap.get(v);
            Object object = persistentMap = persistentMap2 != null ? persistentMap2.remove(mt) : null;
            if (persistentMap != null) {
                ((Map)this.heap).put(v, persistentMap);
            }
        } else {
            PersistentMap persistentMap = (PersistentMap)this.heap.get(v);
            if (persistentMap == null) {
                persistentMap = ExtensionsKt.persistentHashMapOf();
            }
            PersistentMap map = persistentMap;
            IData newData = this.getHf().getPathFactory().setModelData(env, v, mt, data);
            PersistentMap persistentMap3 = map.put(mt, (Object)newData);
            ((Map)this.heap).put(v, persistentMap3);
        }
    }

    public void copyValueData(@NotNull V from, @NotNull V to) {
        Intrinsics.checkNotNullParameter(from, (String)"from");
        Intrinsics.checkNotNullParameter(to, (String)"to");
        Map map = (Map)this.heap;
        PersistentMap persistentMap = (PersistentMap)this.heap.get(from);
        if (persistentMap == null) {
            return;
        }
        PersistentMap persistentMap2 = persistentMap;
        map.put(to, persistentMap2);
    }

    public final void apply(@NotNull IReNew<V> re) {
        Intrinsics.checkNotNullParameter(re, (String)"re");
        PersistentMap heapOld = this.heap.build();
        for (Map.Entry object : ((Map)heapOld).entrySet()) {
            Object k = object.getKey();
            PersistentMap dataMap = (PersistentMap)object.getValue();
            PersistentMap.Builder dataMapBuilder = dataMap.builder();
            for (Map.Entry entry : ((Map)dataMap).entrySet()) {
                Object mt = entry.getKey();
                IData data = (IData)entry.getValue();
                IData iData = data.cloneAndReNewObjects(re.context((Object)new ReferenceContext.PTG(k, mt)));
                if (iData == data) continue;
                ((Map)dataMapBuilder).put(mt, iData);
            }
            Object rpVal = re.checkNeedReplace(k);
            if (rpVal == null) {
                ((Map)this.heap).put(k, dataMapBuilder.build());
                continue;
            }
            if (Intrinsics.areEqual(k, (Object)rpVal)) continue;
            ((Map)this.heap).put(rpVal, dataMapBuilder.build());
            this.heap.remove(k);
        }
        PersistentMap slotsOld = this.slots.build();
        for (Map.Entry entry : ((Map)slotsOld).entrySet()) {
            Object l = entry.getKey();
            IHeapValues v = (IHeapValues)entry.getValue();
            IHeapValues.Builder vb = v.builder();
            vb.cloneAndReNewObjects(re.context((Object)new ReferenceContext.Slot(l)));
            IHeapValues rpVal = vb.build();
            if (rpVal == v) continue;
            ((Map)this.slots).put(l, rpVal);
        }
    }

    @NotNull
    public IHeapValues<V> getTargets(@NotNull Object slot) {
        return IFact.Builder.DefaultImpls.getTargets((IFact.Builder)this, (Object)slot);
    }

    public boolean isValid() {
        return IFact.Builder.DefaultImpls.isValid((IFact.Builder)this);
    }

    @Nullable
    public IHeapValues<V> getArrayLength(@NotNull V array) {
        return IFact.Builder.DefaultImpls.getArrayLength((IFact.Builder)this, array);
    }

    @Nullable
    public IArrayHeapKV<Integer, V> getArray(@NotNull V array) {
        return IFact.Builder.DefaultImpls.getArray((IFact.Builder)this, array);
    }

    @NotNull
    public IHeapValues<V> getOfSootValue(@NotNull HeapValuesEnv env, @NotNull Value value, @NotNull Type valueType) {
        return IFact.Builder.DefaultImpls.getOfSootValue((IFact.Builder)this, (HeapValuesEnv)env, (Value)value, (Type)valueType);
    }

    private static final Object assignLocal$lambda$0(HeapValuesEnv $env, Object $rhs, IHeapValues $rhsValue) {
        return $env + " assignLocal rhs: " + $rhs + " is " + $rhsValue;
    }

    private static final Object assignNewExpr$lambda$1(HeapValuesEnv $env) {
        return $env + " allocSite is empty";
    }

    private static final Object getHeapKVData$lambda$4$lambda$2(Object $mt, CompanionV $o, Object $key) {
        return "get modelT: " + $mt + " map: " + $o + " [" + $key + "] is not exist";
    }

    private static final Object getTargetsUnsafe$lambda$7(Object $slot) {
        return "error slot value: " + $slot;
    }

    private static final ArrayHeapKV emptyArrayFx$lambda$8(PointsToGraphBuilderAbstract this$0, HeapValuesEnv $env, CompanionV lhsV) {
        Intrinsics.checkNotNullParameter((Object)lhsV, (String)"lhsV");
        Type type = this$0.getType(lhsV);
        ArrayType arrayTy = type instanceof ArrayType ? (ArrayType)type : null;
        IHeapValues allocSite = this$0.getHf().single(lhsV);
        return arrayTy != null ? this$0.getEmptyArraySpace($env, allocSite, arrayTy, null) : null;
    }

    private static final FieldHeapKV emptyFieldFx$lambda$9(PointsToGraphBuilderAbstract this$0, CompanionV lhsV) {
        RefType refTy;
        Intrinsics.checkNotNullParameter((Object)lhsV, (String)"lhsV");
        Type type = this$0.getType(lhsV);
        RefType refType = refTy = type instanceof RefType ? (RefType)type : null;
        return refType != null ? this$0.getEmptyFieldSpace(refType) : null;
    }

    private static final String getArrayValue$lambda$14(Value $rhs) {
        return "error soot.Value: " + $rhs;
    }
}

