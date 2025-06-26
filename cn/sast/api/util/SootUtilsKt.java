/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.ClassPathUtilKt
 *  cn.sast.api.util.SootUtilsKt
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.common.ResourceKt
 *  com.feysh.corax.cache.AnalysisCache$G
 *  com.feysh.corax.cache.AnalysisKey
 *  com.feysh.corax.cache.analysis.SootRangeKey
 *  com.feysh.corax.config.api.utils.UtilsKt
 *  com.google.common.base.Optional
 *  kotlin.Metadata
 *  kotlin.NotImplementedError
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.CallableReference
 *  kotlin.jvm.internal.ClassBasedDeclarationContainer
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KCallable
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KClassifier
 *  kotlin.reflect.KDeclarationContainer
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.KParameter
 *  kotlin.reflect.KType
 *  kotlin.reflect.full.KCallables
 *  kotlin.reflect.jvm.KClassesJvm
 *  kotlin.reflect.jvm.ReflectJvmMapping
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.CharsKt
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Body
 *  soot.BooleanType
 *  soot.ByteType
 *  soot.CharType
 *  soot.DoubleType
 *  soot.FloatType
 *  soot.G
 *  soot.IntType
 *  soot.IntegerType
 *  soot.Local
 *  soot.LongType
 *  soot.Printer
 *  soot.RefLikeType
 *  soot.Scene
 *  soot.ShortType
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.SootMethodRef
 *  soot.SourceLocator
 *  soot.Type
 *  soot.Unit
 *  soot.Value
 *  soot.asm.AsmUtil
 *  soot.jimple.AddExpr
 *  soot.jimple.AndExpr
 *  soot.jimple.ArithmeticConstant
 *  soot.jimple.ClassConstant
 *  soot.jimple.CmpExpr
 *  soot.jimple.CmpgExpr
 *  soot.jimple.CmplExpr
 *  soot.jimple.Constant
 *  soot.jimple.DefinitionStmt
 *  soot.jimple.DivExpr
 *  soot.jimple.DoubleConstant
 *  soot.jimple.EqExpr
 *  soot.jimple.Expr
 *  soot.jimple.FloatConstant
 *  soot.jimple.GeExpr
 *  soot.jimple.GtExpr
 *  soot.jimple.InstanceInvokeExpr
 *  soot.jimple.IntConstant
 *  soot.jimple.InvokeExpr
 *  soot.jimple.JasminClass
 *  soot.jimple.LeExpr
 *  soot.jimple.LongConstant
 *  soot.jimple.LtExpr
 *  soot.jimple.MulExpr
 *  soot.jimple.NeExpr
 *  soot.jimple.NullConstant
 *  soot.jimple.NumericConstant
 *  soot.jimple.OrExpr
 *  soot.jimple.RealConstant
 *  soot.jimple.RemExpr
 *  soot.jimple.ShlExpr
 *  soot.jimple.ShrExpr
 *  soot.jimple.SpecialInvokeExpr
 *  soot.jimple.Stmt
 *  soot.jimple.StringConstant
 *  soot.jimple.SubExpr
 *  soot.jimple.UshrExpr
 *  soot.jimple.XorExpr
 *  soot.jimple.toolkits.callgraph.VirtualCalls
 *  soot.tagkit.SourceFileTag
 *  soot.tagkit.Tag
 *  soot.util.Chain
 *  soot.util.JasminOutputStream
 *  soot.util.queue.ChunkedQueue
 *  soot.util.queue.QueueReader
 */
package cn.sast.api.util;

import cn.sast.api.util.ClassPathUtilKt;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.ResourceKt;
import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisKey;
import com.feysh.corax.cache.analysis.SootRangeKey;
import com.feysh.corax.config.api.utils.UtilsKt;
import com.google.common.base.Optional;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.jvm.KClassesJvm;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Body;
import soot.BooleanType;
import soot.ByteType;
import soot.CharType;
import soot.DoubleType;
import soot.FloatType;
import soot.G;
import soot.IntType;
import soot.IntegerType;
import soot.Local;
import soot.LongType;
import soot.Printer;
import soot.RefLikeType;
import soot.Scene;
import soot.ShortType;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.SourceLocator;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.asm.AsmUtil;
import soot.jimple.AddExpr;
import soot.jimple.AndExpr;
import soot.jimple.ArithmeticConstant;
import soot.jimple.ClassConstant;
import soot.jimple.CmpExpr;
import soot.jimple.CmpgExpr;
import soot.jimple.CmplExpr;
import soot.jimple.Constant;
import soot.jimple.DefinitionStmt;
import soot.jimple.DivExpr;
import soot.jimple.DoubleConstant;
import soot.jimple.EqExpr;
import soot.jimple.Expr;
import soot.jimple.FloatConstant;
import soot.jimple.GeExpr;
import soot.jimple.GtExpr;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.JasminClass;
import soot.jimple.LeExpr;
import soot.jimple.LongConstant;
import soot.jimple.LtExpr;
import soot.jimple.MulExpr;
import soot.jimple.NeExpr;
import soot.jimple.NullConstant;
import soot.jimple.NumericConstant;
import soot.jimple.OrExpr;
import soot.jimple.RealConstant;
import soot.jimple.RemExpr;
import soot.jimple.ShlExpr;
import soot.jimple.ShrExpr;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StringConstant;
import soot.jimple.SubExpr;
import soot.jimple.UshrExpr;
import soot.jimple.XorExpr;
import soot.jimple.toolkits.callgraph.VirtualCalls;
import soot.tagkit.SourceFileTag;
import soot.tagkit.Tag;
import soot.util.Chain;
import soot.util.JasminOutputStream;
import soot.util.queue.ChunkedQueue;
import soot.util.queue.QueueReader;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u00dc\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0002\u001a\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\n\u001a\u001e\u0010$\u001a\u00020%\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010&\u001a\u00020'\u001a\u001a\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b022\u0006\u00103\u001a\u00020)\u001a\u001a\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b022\u0006\u00104\u001a\u00020\u000b\u001a\f\u00105\u001a\u0004\u0018\u00010\u000b*\u00020)\u001a\u0014\u00106\u001a\u0004\u0018\u000107*\u0002082\u0006\u00109\u001a\u00020\u0014\u001a\u001c\u0010:\u001a\u0004\u0018\u000108*\u0002072\u0006\u0010;\u001a\u0002072\u0006\u0010<\u001a\u00020'\u001a \u0010=\u001a\u0004\u0018\u0001082\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u0002072\u0006\u0010A\u001a\u000207\u001a+\u0010M\u001a\u0004\u0018\u000108\"\b\b\u0000\u0010N*\u00020\u0014*\u00020O2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u0002HN\u00a2\u0006\u0002\u0010S\u001a+\u0010M\u001a\u0004\u0018\u000108\"\b\b\u0000\u0010N*\u00020\u0014*\u00020\u000b2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u0002HN\u00a2\u0006\u0002\u0010T\u001a\u001e\u0010U\u001a\u00020\u0014*\u0002072\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00140WH\u0086\b\u00f8\u0001\u0000\u001a\u0016\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u000b2\u0006\u0010[\u001a\u00020)\u001a\u0016\u0010\\\u001a\u00020]2\u0006\u0010[\u001a\u00020)2\u0006\u0010^\u001a\u00020_\u001a\u001a\u0010`\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u0014022\u0006\u0010a\u001a\u00020\u0002\u001a2\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001c0c2\u0006\u0010R\u001a\u00020\u00142\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010e\u001a\u00020C2\b\b\u0002\u0010f\u001a\u00020'\u001a\u0012\u0010g\u001a\u00020Y*\u00020)2\u0006\u0010h\u001a\u00020Q\u001a\f\u0010i\u001a\u0004\u0018\u00010)*\u00020)\u001a\u0016\u0010j\u001a\b\u0012\u0004\u0012\u00020)0\n2\u0006\u0010k\u001a\u00020)H\u0002\u001a\u0018\u0010l\u001a\b\u0012\u0004\u0012\u00020\u001c0m*\u00020)2\u0006\u0010\u0011\u001a\u00020\u000b\u001a7\u0010l\u001a\u0004\u0018\u00010\u001c*\u00020)2\u0006\u0010\u0011\u001a\u00020\u000b2!\u0010n\u001a\u001d\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\bp\u0012\b\bq\u0012\u0004\b\b(r\u0012\u0004\u0012\u00020'0o\"%\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"'\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00058F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\"!\u0010\u000e\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"!\u0010\u0011\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010\"!\u0010\u0013\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"!\u0010\u0017\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0010\"!\u0010\u0019\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0010\"#\u0010\u001b\u001a\u0004\u0018\u00010\u001c\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\"!\u0010\u001f\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00058F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001e\"\u0019\u0010(\u001a\u00020)*\u0006\u0012\u0002\b\u00030\u00018F\u00a2\u0006\u0006\u001a\u0004\b*\u0010+\"\u0019\u0010,\u001a\u00020\u000b*\u0006\u0012\u0002\b\u00030\u00018F\u00a2\u0006\u0006\u001a\u0004\b-\u0010.\"\u001b\u0010/\u001a\u0004\u0018\u00010)*\u0006\u0012\u0002\b\u00030\u00018F\u00a2\u0006\u0006\u001a\u0004\b0\u0010+\"\u0018\u0010B\u001a\u0004\u0018\u00010C*\u00020D8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\bE\u0010F\"\u0018\u0010B\u001a\u0004\u0018\u00010C*\u00020G8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\bE\u0010H\"\u0018\u0010I\u001a\u0004\u0018\u00010J*\u00020D8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\bK\u0010L\"\u0015\u0010s\u001a\u00020Q*\u00020)8F\u00a2\u0006\u0006\u001a\u0004\bt\u0010u\"\u0017\u0010v\u001a\u0004\u0018\u00010\u000b*\u00020)8F\u00a2\u0006\u0006\u001a\u0004\bw\u0010x\"%\u0010y\u001a\u0012\u0012\u0004\u0012\u00020\u000b0zj\b\u0012\u0004\u0012\u00020\u000b`{*\u00020)8F\u00a2\u0006\u0006\u001a\u0004\b|\u0010}\"\u0019\u0010~\u001a\u0004\u0018\u00010\u007f*\u00020\u001c8F\u00a2\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0082\u0001"}, d2={"tryConstructor", "Lkotlin/reflect/KClass;", "", "R", "function", "Lkotlin/reflect/KCallable;", "KClass", "getKClass", "(Lkotlin/reflect/KCallable;)Lkotlin/reflect/KClass;", "paramStringList", "", "", "getParamStringList", "(Lkotlin/reflect/KCallable;)Ljava/util/List;", "paramSignature", "getParamSignature", "(Lkotlin/reflect/KCallable;)Ljava/lang/String;", "subSignature", "getSubSignature", "returnSootType", "Lsoot/Type;", "getReturnSootType", "(Lkotlin/reflect/KCallable;)Lsoot/Type;", "sootClassName", "getSootClassName", "sootSignature", "getSootSignature", "grabSootMethod", "Lsoot/SootMethod;", "getGrabSootMethod", "(Lkotlin/reflect/KCallable;)Lsoot/SootMethod;", "sootMethod", "getSootMethod", "convertParameterTypes", "paramTypes", "", "sootMethodRef", "Lsoot/SootMethodRef;", "isStatic", "", "sootClass", "Lsoot/SootClass;", "getSootClass", "(Lkotlin/reflect/KClass;)Lsoot/SootClass;", "className", "getClassName", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "sootClassUnsafe", "getSootClassUnsafe", "classSplit", "Lkotlin/Pair;", "cp", "cname", "getSourcePathFromAnnotation", "castTo", "Lsoot/jimple/Constant;", "Lsoot/jimple/NumericConstant;", "toType", "equalEqual", "b", "isEq", "evalConstantBinop", "expr", "Lsoot/jimple/Expr;", "c1", "c2", "invokeExprOrNull", "Lsoot/jimple/InvokeExpr;", "Lsoot/Unit;", "getInvokeExprOrNull", "(Lsoot/Unit;)Lsoot/jimple/InvokeExpr;", "Lsoot/jimple/Stmt;", "(Lsoot/jimple/Stmt;)Lsoot/jimple/InvokeExpr;", "leftOp", "Lsoot/Value;", "getLeftOp", "(Lsoot/Unit;)Lsoot/Value;", "cvtNumericConstant", "ToType", "Lsoot/jimple/StringConstant;", "radix", "", "type", "(Lsoot/jimple/StringConstant;ILsoot/Type;)Lsoot/jimple/NumericConstant;", "(Ljava/lang/String;ILsoot/Type;)Lsoot/jimple/NumericConstant;", "accurateType", "declareType", "Lkotlin/Function0;", "printToSootClass", "", "dir", "sClass", "sootClass2JasminClass", "Lcn/sast/common/IResFile;", "out", "Lcn/sast/common/IResDirectory;", "constOf", "v", "getCallTargets", "", "container", "ie", "appOnly", "adjustLevel", "level", "superClassOrNull", "findAncestors", "sc", "findMethodOrNull", "Lkotlin/sequences/Sequence;", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sm", "numCode", "getNumCode", "(Lsoot/SootClass;)I", "sourcePath", "getSourcePath", "(Lsoot/SootClass;)Ljava/lang/String;", "possibleSourceFiles", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "getPossibleSourceFiles", "(Lsoot/SootClass;)Ljava/util/LinkedHashSet;", "activeBodyOrNull", "Lsoot/Body;", "getActiveBodyOrNull", "(Lsoot/SootMethod;)Lsoot/Body;", "corax-api"})
@SourceDebugExtension(value={"SMAP\nSootUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SootUtils.kt\ncn/sast/api/util/SootUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,512:1\n1557#2:513\n1628#2,3:514\n1557#2:517\n1628#2,3:518\n1368#2:522\n1454#2,5:523\n1368#2:528\n1454#2,5:529\n1454#2,2:536\n1557#2:538\n1628#2,3:539\n1456#2,3:542\n1368#2:545\n1454#2,5:546\n1#3:521\n183#4,2:534\n*S KotlinDebug\n*F\n+ 1 SootUtils.kt\ncn/sast/api/util/SootUtilsKt\n*L\n52#1:513\n52#1:514,3\n55#1:517\n55#1:518,3\n441#1:522\n441#1:523,5\n442#1:528\n442#1:529,5\n506#1:536,2\n507#1:538\n507#1:539,3\n506#1:542,3\n455#1:545\n455#1:546,5\n474#1:534,2\n*E\n"})
public final class SootUtilsKt {
    private static final <R> KClass<? extends Object> tryConstructor(KCallable<? extends R> function) {
        Class declaringClass;
        Object object = function instanceof KFunction ? (KFunction)function : null;
        Class clazz = declaringClass = object != null && (object = ReflectJvmMapping.getJavaConstructor((KFunction)object)) != null ? ((Constructor)object).getDeclaringClass() : null;
        return clazz != null ? JvmClassMappingKt.getKotlinClass(clazz) : null;
    }

    @NotNull
    public static final <R> KClass<?> getKClass(@NotNull KCallable<? extends R> $this$KClass) {
        KClass kClass;
        Object object;
        Intrinsics.checkNotNullParameter($this$KClass, (String)"<this>");
        if ($this$KClass instanceof CallableReference) {
            KDeclarationContainer kDeclarationContainer = ((CallableReference)$this$KClass).getOwner();
            object = kDeclarationContainer instanceof KClass ? (KClass)kDeclarationContainer : null;
        } else {
            KParameter kParameter = KCallables.getInstanceParameter($this$KClass);
            KClassifier kClassifier = kParameter != null && (kParameter = kParameter.getType()) != null ? kParameter.getClassifier() : null;
            object = kClass = kClassifier instanceof KClass ? (KClass)kClassifier : null;
        }
        if (object == null && (kClass = SootUtilsKt.tryConstructor($this$KClass)) == null) {
            throw new IllegalStateException(("Can't get parent class for " + $this$KClass).toString());
        }
        return kClass;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <R> List<String> getParamStringList(@NotNull KCallable<? extends R> $this$paramStringList) {
        List list;
        Intrinsics.checkNotNullParameter($this$paramStringList, (String)"<this>");
        if ($this$paramStringList instanceof CallableReference) {
            void $this$mapTo$iv$iv;
            String string = ((CallableReference)$this$paramStringList).getSignature();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getSignature(...)");
            List sigTypes = AsmUtil.toJimpleDesc((String)StringsKt.substringAfter$default((String)string, (String)"(", null, (int)2, null), (Optional)Optional.fromNullable(null));
            sigTypes.remove(sigTypes.size() - 1);
            Intrinsics.checkNotNull((Object)sigTypes);
            Iterable $this$map$iv = sigTypes;
            boolean $i$f$map2 = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv2 : $this$mapTo$iv$iv) {
                void it;
                Type type = (Type)item$iv$iv2;
                Collection collection = destination$iv$iv;
                boolean bl = false;
                Intrinsics.checkNotNull((Object)it);
                String string2 = UtilsKt.getTypename((Type)it);
                Intrinsics.checkNotNull((Object)string2);
                collection.add(string2);
            }
            list = (List)destination$iv$iv;
        } else {
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = CollectionsKt.drop((Iterable)$this$paramStringList.getParameters(), (int)(KCallables.getInstanceParameter($this$paramStringList) != null ? 1 : 0));
            boolean $i$f$map = false;
            Iterable $i$f$map2 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                KParameter item$iv$iv2 = (KParameter)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl = false;
                String string = ReflectJvmMapping.getJavaType((KType)it.getType()).getTypeName();
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getTypeName(...)");
                collection.add(StringsKt.substringBefore$default((String)string, (char)'<', null, (int)2, null));
            }
            list = (List)destination$iv$iv;
        }
        return list;
    }

    @NotNull
    public static final <R> String getParamSignature(@NotNull KCallable<? extends R> $this$paramSignature) {
        Intrinsics.checkNotNullParameter($this$paramSignature, (String)"<this>");
        return CollectionsKt.joinToString$default((Iterable)SootUtilsKt.getParamStringList($this$paramSignature), (CharSequence)",", null, null, (int)0, null, null, (int)62, null);
    }

    @NotNull
    public static final <R> String getSubSignature(@NotNull KCallable<? extends R> $this$subSignature) {
        Intrinsics.checkNotNullParameter($this$subSignature, (String)"<this>");
        if ($this$subSignature instanceof CallableReference) {
            String string = ((CallableReference)$this$subSignature).getSignature();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getSignature(...)");
            List sigTypes = AsmUtil.toJimpleDesc((String)StringsKt.substringAfter$default((String)string, (String)"(", null, (int)2, null), (Optional)Optional.fromNullable(null));
            Type returnType = (Type)sigTypes.remove(sigTypes.size() - 1);
            Intrinsics.checkNotNull((Object)sigTypes);
            String signature = CollectionsKt.joinToString$default((Iterable)sigTypes, (CharSequence)",", null, null, (int)0, null, SootUtilsKt::_get_subSignature_$lambda$2, (int)30, null);
            return returnType + " " + ((CallableReference)$this$subSignature).getName() + "(" + signature + ")";
        }
        return ReflectJvmMapping.getJavaType((KType)$this$subSignature.getReturnType()).getTypeName() + " " + $this$subSignature.getName() + "(" + SootUtilsKt.getParamSignature($this$subSignature) + ")";
    }

    @NotNull
    public static final <R> Type getReturnSootType(@NotNull KCallable<? extends R> $this$returnSootType) {
        String string;
        Intrinsics.checkNotNullParameter($this$returnSootType, (String)"<this>");
        if ($this$returnSootType instanceof CallableReference) {
            String string2 = ((CallableReference)$this$returnSootType).getSignature();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getSignature(...)");
            List sigTypes = AsmUtil.toJimpleDesc((String)StringsKt.substringAfter$default((String)string2, (String)"(", null, (int)2, null), (Optional)Optional.fromNullable(null));
            string = ((Type)sigTypes.remove(sigTypes.size() - 1)).toString();
        } else {
            string = ReflectJvmMapping.getJavaType((KType)$this$returnSootType.getReturnType()).getTypeName();
        }
        String ty = string;
        Type type = Scene.v().getTypeUnsafe(ty, true);
        Intrinsics.checkNotNull((Object)type);
        return type;
    }

    @NotNull
    public static final <R> String getSootClassName(@NotNull KCallable<? extends R> $this$sootClassName) {
        String string;
        Intrinsics.checkNotNullParameter($this$sootClassName, (String)"<this>");
        KClass ks = SootUtilsKt.getKClass($this$sootClassName);
        if (ks instanceof ClassBasedDeclarationContainer) {
            String string2 = ((ClassBasedDeclarationContainer)ks).getJClass().getName();
            string = string2;
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getName(...)");
        } else {
            String string3 = ks.getQualifiedName();
            string = string3;
            Intrinsics.checkNotNull((Object)string3);
        }
        return string;
    }

    @NotNull
    public static final <R> String getSootSignature(@NotNull KCallable<? extends R> $this$sootSignature) {
        Intrinsics.checkNotNullParameter($this$sootSignature, (String)"<this>");
        return "<" + SootUtilsKt.getSootClassName($this$sootSignature) + ": " + SootUtilsKt.getSubSignature($this$sootSignature) + ">";
    }

    @Nullable
    public static final <R> SootMethod getGrabSootMethod(@NotNull KCallable<? extends R> $this$grabSootMethod) {
        Intrinsics.checkNotNullParameter($this$grabSootMethod, (String)"<this>");
        return Scene.v().grabMethod(SootUtilsKt.getSootSignature($this$grabSootMethod));
    }

    @NotNull
    public static final <R> SootMethod getSootMethod(@NotNull KCallable<? extends R> $this$sootMethod) {
        Intrinsics.checkNotNullParameter($this$sootMethod, (String)"<this>");
        SootMethod sootMethod = Scene.v().getMethod(SootUtilsKt.getSootSignature($this$sootMethod));
        Intrinsics.checkNotNullExpressionValue((Object)sootMethod, (String)"getMethod(...)");
        return sootMethod;
    }

    @NotNull
    public static final List<Type> convertParameterTypes(@NotNull List<? extends CharSequence> paramTypes) {
        Intrinsics.checkNotNullParameter(paramTypes, (String)"paramTypes");
        List parameterTypes = new ArrayList();
        for (CharSequence charSequence : paramTypes) {
            Type type = Scene.v().getTypeUnsafe(((Object)charSequence).toString(), true);
            Intrinsics.checkNotNull((Object)type);
            parameterTypes.add(type);
        }
        return parameterTypes;
    }

    @NotNull
    public static final <R> SootMethodRef sootMethodRef(@NotNull KCallable<? extends R> $this$sootMethodRef, boolean isStatic) {
        Intrinsics.checkNotNullParameter($this$sootMethodRef, (String)"<this>");
        SootClass sootClass = Scene.v().getSootClass(SootUtilsKt.getSootClassName($this$sootMethodRef));
        Intrinsics.checkNotNull((Object)sootClass);
        SootClass sc = sootClass;
        SootMethodRef sootMethodRef = Scene.v().makeMethodRef(sc, $this$sootMethodRef.getName(), SootUtilsKt.convertParameterTypes((List)SootUtilsKt.getParamStringList($this$sootMethodRef)), SootUtilsKt.getReturnSootType($this$sootMethodRef), isStatic);
        Intrinsics.checkNotNullExpressionValue((Object)sootMethodRef, (String)"makeMethodRef(...)");
        return sootMethodRef;
    }

    @NotNull
    public static final SootClass getSootClass(@NotNull KClass<?> $this$sootClass) {
        Intrinsics.checkNotNullParameter($this$sootClass, (String)"<this>");
        SootClass sootClass = Scene.v().getSootClass(KClassesJvm.getJvmName($this$sootClass));
        Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getSootClass(...)");
        return sootClass;
    }

    @NotNull
    public static final String getClassName(@NotNull KClass<?> $this$className) {
        Intrinsics.checkNotNullParameter($this$className, (String)"<this>");
        return KClassesJvm.getJvmName($this$className);
    }

    @Nullable
    public static final SootClass getSootClassUnsafe(@NotNull KClass<?> $this$sootClassUnsafe) {
        Intrinsics.checkNotNullParameter($this$sootClassUnsafe, (String)"<this>");
        return Scene.v().getSootClassUnsafe(KClassesJvm.getJvmName($this$sootClassUnsafe), false);
    }

    @NotNull
    public static final Pair<String, String> classSplit(@NotNull SootClass cp) {
        Intrinsics.checkNotNullParameter((Object)cp, (String)"cp");
        String string = cp.getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
        return SootUtilsKt.classSplit((String)string);
    }

    @NotNull
    public static final Pair<String, String> classSplit(@NotNull String cname) {
        Intrinsics.checkNotNullParameter((Object)cname, (String)"cname");
        String packageName = StringsKt.substringBeforeLast((String)cname, (String)".", (String)"");
        String className = StringsKt.substringAfterLast$default((String)cname, (String)".", null, (int)2, null);
        return TuplesKt.to((Object)packageName, (Object)className);
    }

    @Nullable
    public static final String getSourcePathFromAnnotation(@NotNull SootClass $this$getSourcePathFromAnnotation) {
        Intrinsics.checkNotNullParameter((Object)$this$getSourcePathFromAnnotation, (String)"<this>");
        Tag tag = $this$getSourcePathFromAnnotation.getTag("SourceFileTag");
        SourceFileTag sourceFileTag = tag instanceof SourceFileTag ? (SourceFileTag)tag : null;
        if (sourceFileTag == null) {
            return null;
        }
        SourceFileTag sft = sourceFileTag;
        String source = sft.getSourceFile();
        Intrinsics.checkNotNull((Object)source);
        String fixed = StringsKt.substringBeforeLast$default((String)StringsKt.substringBeforeLast$default((String)StringsKt.substringBeforeLast$default((String)source, (String)"..", null, (int)2, null), (String)"/", null, (int)2, null), (String)"\\", null, (int)2, null);
        String string = StringsKt.substringAfterLast$default((String)fixed, (String)".", null, (int)2, null);
        if (!ResourceKt.getJavaExtensions().contains(string)) {
            return null;
        }
        String packageName = StringsKt.replace$default((String)((String)SootUtilsKt.classSplit((SootClass)$this$getSourcePathFromAnnotation).getFirst()), (String)".", (String)"/", (boolean)false, (int)4, null);
        if (((CharSequence)packageName).length() == 0) {
            return fixed;
        }
        return packageName + "/" + fixed;
    }

    @Nullable
    public static final Constant castTo(@NotNull NumericConstant $this$castTo, @NotNull Type toType) {
        Intrinsics.checkNotNullParameter((Object)$this$castTo, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)toType, (String)"toType");
        if (toType instanceof BooleanType) {
            if ($this$castTo instanceof IntConstant) {
                return (Constant)IntConstant.v((int)(((IntConstant)$this$castTo).value != 0 ? 1 : 0));
            }
            if ($this$castTo instanceof LongConstant) {
                return (Constant)IntConstant.v((int)((int)((LongConstant)$this$castTo).value != 0 ? 1 : 0));
            }
            if ($this$castTo instanceof FloatConstant) {
                return (Constant)IntConstant.v((int)((int)((FloatConstant)$this$castTo).value != 0 ? 1 : 0));
            }
            if ($this$castTo instanceof DoubleConstant) {
                return (Constant)IntConstant.v((int)((int)((DoubleConstant)$this$castTo).value != 0 ? 1 : 0));
            }
        } else if (toType instanceof ByteType) {
            if ($this$castTo instanceof IntConstant) {
                return (Constant)IntConstant.v((int)((byte)((IntConstant)$this$castTo).value));
            }
            if ($this$castTo instanceof LongConstant) {
                return (Constant)IntConstant.v((int)((byte)((LongConstant)$this$castTo).value));
            }
            if ($this$castTo instanceof FloatConstant) {
                return (Constant)IntConstant.v((int)((byte)((FloatConstant)$this$castTo).value));
            }
            if ($this$castTo instanceof DoubleConstant) {
                return (Constant)IntConstant.v((int)((byte)((DoubleConstant)$this$castTo).value));
            }
        } else if (toType instanceof CharType) {
            if ($this$castTo instanceof IntConstant) {
                return (Constant)IntConstant.v((int)((char)((IntConstant)$this$castTo).value));
            }
            if ($this$castTo instanceof LongConstant) {
                return (Constant)IntConstant.v((int)((char)((LongConstant)$this$castTo).value));
            }
            if ($this$castTo instanceof FloatConstant) {
                return (Constant)IntConstant.v((int)((char)((FloatConstant)$this$castTo).value));
            }
            if ($this$castTo instanceof DoubleConstant) {
                return (Constant)IntConstant.v((int)((char)((DoubleConstant)$this$castTo).value));
            }
        } else if (toType instanceof ShortType) {
            if ($this$castTo instanceof IntConstant) {
                return (Constant)IntConstant.v((int)((short)((IntConstant)$this$castTo).value));
            }
            if ($this$castTo instanceof LongConstant) {
                return (Constant)IntConstant.v((int)((short)((LongConstant)$this$castTo).value));
            }
            if ($this$castTo instanceof FloatConstant) {
                return (Constant)IntConstant.v((int)((short)((FloatConstant)$this$castTo).value));
            }
            if ($this$castTo instanceof DoubleConstant) {
                return (Constant)IntConstant.v((int)((short)((DoubleConstant)$this$castTo).value));
            }
        } else if (toType instanceof IntType) {
            if ($this$castTo instanceof IntConstant) {
                return (Constant)$this$castTo;
            }
            if ($this$castTo instanceof LongConstant) {
                return (Constant)IntConstant.v((int)((int)((LongConstant)$this$castTo).value));
            }
            if ($this$castTo instanceof FloatConstant) {
                return (Constant)IntConstant.v((int)((int)((FloatConstant)$this$castTo).value));
            }
            if ($this$castTo instanceof DoubleConstant) {
                return (Constant)IntConstant.v((int)((int)((DoubleConstant)$this$castTo).value));
            }
        } else if (toType instanceof LongType) {
            if ($this$castTo instanceof IntConstant) {
                return (Constant)LongConstant.v((long)((IntConstant)$this$castTo).value);
            }
            if ($this$castTo instanceof LongConstant) {
                return (Constant)$this$castTo;
            }
            if ($this$castTo instanceof FloatConstant) {
                return (Constant)LongConstant.v((long)((long)((FloatConstant)$this$castTo).value));
            }
            if ($this$castTo instanceof DoubleConstant) {
                return (Constant)LongConstant.v((long)((long)((DoubleConstant)$this$castTo).value));
            }
        } else if (toType instanceof FloatType) {
            if ($this$castTo instanceof IntConstant) {
                return (Constant)FloatConstant.v((float)((IntConstant)$this$castTo).value);
            }
            if ($this$castTo instanceof LongConstant) {
                return (Constant)FloatConstant.v((float)((LongConstant)$this$castTo).value);
            }
            if ($this$castTo instanceof FloatConstant) {
                return (Constant)$this$castTo;
            }
            if ($this$castTo instanceof DoubleConstant) {
                return (Constant)FloatConstant.v((float)((float)((DoubleConstant)$this$castTo).value));
            }
        } else if (toType instanceof DoubleType) {
            if ($this$castTo instanceof IntConstant) {
                return (Constant)DoubleConstant.v((double)((IntConstant)$this$castTo).value);
            }
            if ($this$castTo instanceof LongConstant) {
                return (Constant)DoubleConstant.v((double)((LongConstant)$this$castTo).value);
            }
            if ($this$castTo instanceof FloatConstant) {
                return (Constant)DoubleConstant.v((double)((FloatConstant)$this$castTo).value);
            }
            if ($this$castTo instanceof DoubleConstant) {
                return (Constant)$this$castTo;
            }
        }
        return null;
    }

    @Nullable
    public static final NumericConstant equalEqual(@NotNull Constant $this$equalEqual, @NotNull Constant b, boolean isEq) {
        NumericConstant numericConstant;
        Intrinsics.checkNotNullParameter((Object)$this$equalEqual, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        if ($this$equalEqual instanceof NumericConstant) {
            numericConstant = !(b instanceof NumericConstant) ? (NumericConstant)IntConstant.v((int)0) : (isEq ? ((NumericConstant)$this$equalEqual).equalEqual((NumericConstant)b) : ((NumericConstant)$this$equalEqual).notEqual((NumericConstant)b));
        } else if ($this$equalEqual instanceof StringConstant || $this$equalEqual instanceof NullConstant || $this$equalEqual instanceof ClassConstant) {
            boolean equality = Intrinsics.areEqual((Object)$this$equalEqual, (Object)b);
            boolean truth = isEq ? equality : !equality;
            numericConstant = (NumericConstant)IntConstant.v((int)(truth ? 1 : 0));
        } else {
            numericConstant = null;
        }
        return numericConstant;
    }

    @Nullable
    public static final NumericConstant evalConstantBinop(@NotNull Expr expr, @NotNull Constant c1, @NotNull Constant c2) throws ArithmeticException, IllegalArgumentException {
        Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
        Intrinsics.checkNotNullParameter((Object)c1, (String)"c1");
        Intrinsics.checkNotNullParameter((Object)c2, (String)"c2");
        Expr expr2 = expr;
        return expr2 instanceof AddExpr ? ((NumericConstant)c1).add((NumericConstant)c2) : (expr2 instanceof SubExpr ? ((NumericConstant)c1).subtract((NumericConstant)c2) : (expr2 instanceof MulExpr ? ((NumericConstant)c1).multiply((NumericConstant)c2) : (expr2 instanceof DivExpr ? ((NumericConstant)c1).divide((NumericConstant)c2) : (expr2 instanceof RemExpr ? ((NumericConstant)c1).remainder((NumericConstant)c2) : (expr2 instanceof EqExpr ? SootUtilsKt.equalEqual((Constant)c1, (Constant)c2, (boolean)true) : (expr2 instanceof NeExpr ? SootUtilsKt.equalEqual((Constant)c1, (Constant)c2, (boolean)false) : (expr2 instanceof GtExpr ? ((NumericConstant)c1).greaterThan((NumericConstant)c2) : (expr2 instanceof GeExpr ? ((NumericConstant)c1).greaterThanOrEqual((NumericConstant)c2) : (expr2 instanceof LtExpr ? ((NumericConstant)c1).lessThan((NumericConstant)c2) : (expr2 instanceof LeExpr ? ((NumericConstant)c1).lessThanOrEqual((NumericConstant)c2) : (expr2 instanceof AndExpr ? (NumericConstant)((ArithmeticConstant)c1).and((ArithmeticConstant)c2) : (expr2 instanceof OrExpr ? (NumericConstant)((ArithmeticConstant)c1).or((ArithmeticConstant)c2) : (expr2 instanceof XorExpr ? (NumericConstant)((ArithmeticConstant)c1).xor((ArithmeticConstant)c2) : (expr2 instanceof ShlExpr ? (NumericConstant)((ArithmeticConstant)c1).shiftLeft((ArithmeticConstant)c2) : (expr2 instanceof ShrExpr ? (NumericConstant)((ArithmeticConstant)c1).shiftRight((ArithmeticConstant)c2) : (expr2 instanceof UshrExpr ? (NumericConstant)((ArithmeticConstant)c1).unsignedShiftRight((ArithmeticConstant)c2) : (expr2 instanceof CmpExpr ? (NumericConstant)(c1 instanceof LongConstant && c2 instanceof LongConstant ? ((LongConstant)c1).cmp((LongConstant)c2) : null) : (expr2 instanceof CmpgExpr || expr2 instanceof CmplExpr ? (NumericConstant)(c1 instanceof RealConstant && c2 instanceof RealConstant ? (expr instanceof CmpgExpr ? ((RealConstant)c1).cmpg((RealConstant)c2) : (expr instanceof CmplExpr ? ((RealConstant)c1).cmpl((RealConstant)c2) : null)) : null) : null))))))))))))))))));
    }

    @Nullable
    public static final InvokeExpr getInvokeExprOrNull(@NotNull Unit $this$invokeExprOrNull) {
        InvokeExpr invokeExpr;
        Intrinsics.checkNotNullParameter((Object)$this$invokeExprOrNull, (String)"<this>");
        boolean $i$f$getInvokeExprOrNull = false;
        Stmt stmt = $this$invokeExprOrNull instanceof Stmt ? (Stmt)$this$invokeExprOrNull : null;
        if (stmt != null) {
            Stmt it = stmt;
            boolean bl = false;
            invokeExpr = ((Stmt)$this$invokeExprOrNull).containsInvokeExpr() ? ((Stmt)$this$invokeExprOrNull).getInvokeExpr() : null;
        } else {
            invokeExpr = null;
        }
        return invokeExpr;
    }

    @Nullable
    public static final InvokeExpr getInvokeExprOrNull(@NotNull Stmt $this$invokeExprOrNull) {
        Intrinsics.checkNotNullParameter((Object)$this$invokeExprOrNull, (String)"<this>");
        boolean $i$f$getInvokeExprOrNull = false;
        Stmt it = $this$invokeExprOrNull;
        boolean bl = false;
        return $this$invokeExprOrNull.containsInvokeExpr() ? $this$invokeExprOrNull.getInvokeExpr() : null;
    }

    @Nullable
    public static final Value getLeftOp(@NotNull Unit $this$leftOp) {
        Intrinsics.checkNotNullParameter((Object)$this$leftOp, (String)"<this>");
        boolean $i$f$getLeftOp = false;
        DefinitionStmt definitionStmt = $this$leftOp instanceof DefinitionStmt ? (DefinitionStmt)$this$leftOp : null;
        return definitionStmt != null ? definitionStmt.getLeftOp() : null;
    }

    @Nullable
    public static final <ToType extends Type> NumericConstant cvtNumericConstant(@NotNull StringConstant $this$cvtNumericConstant, int radix, @NotNull ToType type) throws NumberFormatException {
        Intrinsics.checkNotNullParameter((Object)$this$cvtNumericConstant, (String)"<this>");
        Intrinsics.checkNotNullParameter(type, (String)"type");
        String string = $this$cvtNumericConstant.value;
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"value");
        return SootUtilsKt.cvtNumericConstant((String)string, (int)radix, type);
    }

    @Nullable
    public static final <ToType extends Type> NumericConstant cvtNumericConstant(@NotNull String $this$cvtNumericConstant, int radix, @NotNull ToType type) throws NumberFormatException {
        Intrinsics.checkNotNullParameter((Object)$this$cvtNumericConstant, (String)"<this>");
        Intrinsics.checkNotNullParameter(type, (String)"type");
        if (!(2 <= radix ? radix < 37 : false)) {
            return null;
        }
        ToType ToType = type;
        return ToType instanceof IntegerType ? (NumericConstant)IntConstant.v((int)Integer.parseInt($this$cvtNumericConstant, CharsKt.checkRadix((int)radix))) : (ToType instanceof LongType ? (NumericConstant)LongConstant.v((long)Long.parseLong($this$cvtNumericConstant, CharsKt.checkRadix((int)radix))) : (ToType instanceof FloatType ? (NumericConstant)FloatConstant.v((float)Float.parseFloat($this$cvtNumericConstant)) : (ToType instanceof DoubleType ? (NumericConstant)DoubleConstant.v((double)Double.parseDouble($this$cvtNumericConstant)) : null)));
    }

    @NotNull
    public static final Type accurateType(@NotNull Constant $this$accurateType, @NotNull Function0<? extends Type> declareType) {
        Intrinsics.checkNotNullParameter((Object)$this$accurateType, (String)"<this>");
        Intrinsics.checkNotNullParameter(declareType, (String)"declareType");
        boolean $i$f$accurateType = false;
        Type it = $this$accurateType.getType();
        boolean bl = false;
        return it instanceof RefLikeType ? it : (Type)declareType.invoke();
    }

    public static final void printToSootClass(@NotNull String dir, @NotNull SootClass sClass) {
        Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
        Intrinsics.checkNotNullParameter((Object)sClass, (String)"sClass");
        String filename = SourceLocator.v().getFileNameFor(sClass, 1);
        File p = Paths.get(dir + File.separator + filename, new String[0]).toFile();
        if (!p.getParentFile().exists()) {
            p.getParentFile().mkdirs();
        }
        FileOutputStream streamOut = new FileOutputStream(p);
        PrintWriter writerOut = new PrintWriter(new OutputStreamWriter(streamOut));
        Printer.v().printTo(sClass, writerOut);
        writerOut.flush();
        writerOut.close();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public static final IResFile sootClass2JasminClass(@NotNull SootClass sClass, @NotNull IResDirectory out) throws Exception {
        Intrinsics.checkNotNullParameter((Object)sClass, (String)"sClass");
        Intrinsics.checkNotNullParameter((Object)out, (String)"out");
        String fileName = SourceLocator.v().getFileNameFor(sClass, 14);
        Intrinsics.checkNotNull((Object)fileName);
        IResFile outCLass = out.resolve(fileName).toFile();
        outCLass.mkdirs();
        OpenOption[] openOptionArray = new OpenOption[]{};
        OutputStream outputStream = Files.newOutputStream(outCLass.getPath(), Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream, (String)"newOutputStream(...)");
        Closeable closeable = (Closeable)new JasminOutputStream(outputStream);
        Throwable throwable = null;
        try {
            JasminOutputStream streamOut = (JasminOutputStream)closeable;
            boolean bl = false;
            PrintWriter writerOut = new PrintWriter(new OutputStreamWriter((OutputStream)streamOut));
            JasminClass jasminClass = new JasminClass(sClass);
            jasminClass.print(writerOut);
            writerOut.flush();
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
        return outCLass;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @NotNull
    public static final Pair<Constant, Type> constOf(@NotNull Object v) {
        Pair pair;
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Object object = v;
        if (object instanceof Constant) {
            pair = TuplesKt.to((Object)v, (Object)((Constant)v).getType());
            return pair;
        } else if (object instanceof String) {
            pair = TuplesKt.to((Object)StringConstant.v((String)((String)v)), (Object)Scene.v().getType("java.lang.String"));
            return pair;
        } else if (object instanceof Boolean) {
            pair = TuplesKt.to((Object)IntConstant.v((int)((Boolean)v != false ? 1 : 0)), (Object)G.v().soot_BooleanType());
            return pair;
        } else {
            if (!(object instanceof Number)) throw new NotImplementedError(null, 1, null);
            if (v instanceof Integer) {
                pair = TuplesKt.to((Object)IntConstant.v((int)((Number)v).intValue()), (Object)G.v().soot_IntType());
                return pair;
            } else if (v instanceof Long) {
                pair = TuplesKt.to((Object)LongConstant.v((long)((Number)v).longValue()), (Object)G.v().soot_LongType());
                return pair;
            } else if (v instanceof Double) {
                pair = TuplesKt.to((Object)DoubleConstant.v((double)((Number)v).doubleValue()), (Object)G.v().soot_DoubleType());
                return pair;
            } else if (v instanceof Float) {
                pair = TuplesKt.to((Object)FloatConstant.v((float)((Number)v).floatValue()), (Object)G.v().soot_FloatType());
                return pair;
            } else if (v instanceof Byte) {
                pair = TuplesKt.to((Object)IntConstant.v((int)((Number)v).byteValue()), (Object)G.v().soot_ByteType());
                return pair;
            } else {
                if (!(v instanceof Short)) throw new NotImplementedError(null, 1, null);
                pair = TuplesKt.to((Object)IntConstant.v((int)((Number)v).shortValue()), (Object)G.v().soot_ShortType());
            }
        }
        return pair;
    }

    @NotNull
    public static final Iterator<SootMethod> getCallTargets(@NotNull Type type, @Nullable SootMethod container, @NotNull InvokeExpr ie, boolean appOnly) {
        Type type2;
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)ie, (String)"ie");
        SootMethodRef methodRef = ie.getMethodRef();
        VirtualCalls virtualCalls = VirtualCalls.v();
        ChunkedQueue targetsQueue = new ChunkedQueue();
        QueueReader queueReader = targetsQueue.reader();
        Intrinsics.checkNotNullExpressionValue((Object)queueReader, (String)"reader(...)");
        Iterator iter = (Iterator)queueReader;
        if (ie instanceof SpecialInvokeExpr) {
            SootMethod target = virtualCalls.resolveSpecial(methodRef, container, appOnly);
            if (target != null) {
                targetsQueue.add((Object)target);
            }
            return iter;
        }
        if (ie instanceof InstanceInvokeExpr) {
            Value value = ((InstanceInvokeExpr)ie).getBase();
            Intrinsics.checkNotNull((Object)value, (String)"null cannot be cast to non-null type soot.Local");
            type2 = ((Local)value).getType();
        } else {
            type2 = (Type)methodRef.getDeclaringClass().getType();
        }
        Type receiverType = type2;
        virtualCalls.resolve(type, receiverType, methodRef, container, targetsQueue, appOnly);
        return iter;
    }

    public static /* synthetic */ Iterator getCallTargets$default(Type type, SootMethod sootMethod, InvokeExpr invokeExpr, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            sootMethod = null;
        }
        if ((n & 8) != 0) {
            bl = false;
        }
        return SootUtilsKt.getCallTargets((Type)type, (SootMethod)sootMethod, (InvokeExpr)invokeExpr, (boolean)bl);
    }

    public static final void adjustLevel(@NotNull SootClass $this$adjustLevel, int level) {
        Intrinsics.checkNotNullParameter((Object)$this$adjustLevel, (String)"<this>");
        if ($this$adjustLevel.resolvingLevel() < level) {
            $this$adjustLevel.setResolvingLevel(level);
        }
    }

    @Nullable
    public static final SootClass superClassOrNull(@NotNull SootClass $this$superClassOrNull) {
        Intrinsics.checkNotNullParameter((Object)$this$superClassOrNull, (String)"<this>");
        return $this$superClassOrNull.hasSuperclass() ? $this$superClassOrNull.getSuperclass() : null;
    }

    private static final List<SootClass> findAncestors(SootClass sc) {
        SootClass $this$findAncestors_u24lambda_u249 = sc;
        boolean bl = false;
        List superClasses = new ArrayList();
        List superInterfaces = new ArrayList();
        if ($this$findAncestors_u24lambda_u249.isInterface()) {
            ((Collection)superClasses).add(Scene.v().getObjectType().getSootClass());
            Collection collection = superInterfaces;
            List list = Scene.v().getActiveHierarchy().getSuperinterfacesOfIncluding($this$findAncestors_u24lambda_u249);
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getSuperinterfacesOfIncluding(...)");
            CollectionsKt.addAll((Collection)collection, (Iterable)list);
        } else {
            Iterable list$iv$iv;
            SootClass it;
            Iterable $this$flatMapTo$iv$iv;
            Iterable $this$flatMap$iv;
            Collection collection = superClasses;
            List list = Scene.v().getActiveHierarchy().getSuperclassesOfIncluding($this$findAncestors_u24lambda_u249);
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getSuperclassesOfIncluding(...)");
            CollectionsKt.addAll((Collection)collection, (Iterable)list);
            collection = superInterfaces;
            Iterable iterable = superClasses;
            boolean $i$f$flatMap = false;
            void var8_9 = $this$flatMap$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$flatMapTo = false;
            for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
                it = (SootClass)element$iv$iv;
                boolean bl2 = false;
                Chain chain = it.getInterfaces();
                Intrinsics.checkNotNullExpressionValue((Object)chain, (String)"getInterfaces(...)");
                list$iv$iv = (Iterable)chain;
                CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
            }
            $this$flatMap$iv = (List)destination$iv$iv;
            $i$f$flatMap = false;
            $this$flatMapTo$iv$iv = $this$flatMap$iv;
            destination$iv$iv = new ArrayList();
            $i$f$flatMapTo = false;
            for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
                it = (SootClass)element$iv$iv;
                boolean bl3 = false;
                List list2 = Scene.v().getActiveHierarchy().getSuperinterfacesOfIncluding(it);
                Intrinsics.checkNotNullExpressionValue((Object)list2, (String)"getSuperinterfacesOfIncluding(...)");
                list$iv$iv = list2;
                CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
            }
            iterable = (List)destination$iv$iv;
            CollectionsKt.addAll((Collection)collection, (Iterable)iterable);
        }
        return CollectionsKt.plus((Collection)superClasses, (Iterable)superInterfaces);
    }

    @NotNull
    public static final Sequence<SootMethod> findMethodOrNull(@NotNull SootClass $this$findMethodOrNull, @NotNull String subSignature) {
        Intrinsics.checkNotNullParameter((Object)$this$findMethodOrNull, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)subSignature, (String)"subSignature");
        SootUtilsKt.adjustLevel((SootClass)$this$findMethodOrNull, (int)2);
        String params = StringsKt.substringAfter$default((String)subSignature, (String)" ", null, (int)2, null);
        Sequence classes = SequencesKt.generateSequence((Object)$this$findMethodOrNull, SootUtilsKt::findMethodOrNull$lambda$10);
        Sequence interfaces = SequencesKt.distinct((Sequence)SequencesKt.flatMapIterable((Sequence)SequencesKt.generateSequence((Object)$this$findMethodOrNull, SootUtilsKt::findMethodOrNull$lambda$11), SootUtilsKt::findMethodOrNull$lambda$13));
        return SequencesKt.filter((Sequence)SequencesKt.flatMapIterable((Sequence)SequencesKt.plus((Sequence)classes, (Sequence)interfaces), SootUtilsKt::findMethodOrNull$lambda$14), arg_0 -> SootUtilsKt.findMethodOrNull$lambda$15($this$findMethodOrNull, params, arg_0));
    }

    @Nullable
    public static final SootMethod findMethodOrNull(@NotNull SootClass $this$findMethodOrNull, @NotNull String subSignature, @NotNull Function1<? super SootMethod, Boolean> predicate) {
        Object v0;
        block1: {
            Intrinsics.checkNotNullParameter((Object)$this$findMethodOrNull, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)subSignature, (String)"subSignature");
            Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
            Sequence $this$firstOrNull$iv = SootUtilsKt.findMethodOrNull((SootClass)$this$findMethodOrNull, (String)subSignature);
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                if (!((Boolean)predicate.invoke(element$iv)).booleanValue()) continue;
                v0 = element$iv;
                break block1;
            }
            v0 = null;
        }
        return v0;
    }

    public static final int getNumCode(@NotNull SootClass $this$numCode) {
        Intrinsics.checkNotNullParameter((Object)$this$numCode, (String)"<this>");
        SootClass $this$_get_numCode__u24lambda_u2416 = $this$numCode;
        boolean bl = false;
        int loc = 0;
        for (SootMethod sm : $this$_get_numCode__u24lambda_u2416.getMethods()) {
            if (!sm.hasActiveBody()) continue;
            Intrinsics.checkNotNull((Object)sm);
            Pair range = (Pair)AnalysisCache.G.INSTANCE.get((AnalysisKey)new SootRangeKey(sm));
            if (range == null) continue;
            int firstLineNumber = ((Number)range.component1()).intValue();
            int lastLineNumber = ((Number)range.component2()).intValue();
            loc = Math.max(loc, firstLineNumber);
            loc = Math.max(loc, lastLineNumber);
        }
        return loc;
    }

    @Nullable
    public static final String getSourcePath(@NotNull SootClass $this$sourcePath) {
        Intrinsics.checkNotNullParameter((Object)$this$sourcePath, (String)"<this>");
        return ClassPathUtilKt.getSourcePathModule((SootClass)$this$sourcePath);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final LinkedHashSet<String> getPossibleSourceFiles(@NotNull SootClass $this$possibleSourceFiles) {
        Intrinsics.checkNotNullParameter((Object)$this$possibleSourceFiles, (String)"<this>");
        LinkedHashSet<String> res = new LinkedHashSet<String>();
        String string = SootUtilsKt.getSourcePath((SootClass)$this$possibleSourceFiles);
        if (string != null) {
            String it = string;
            boolean bl = false;
            res.add(it);
        }
        LinkedHashSet<String> list = new LinkedHashSet<String>();
        SourceLocator sourceLocator = SourceLocator.v();
        String string2 = $this$possibleSourceFiles.getName();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getName(...)");
        list.add(sourceLocator.getSourceForClass(StringsKt.replace$default((String)string2, (String)".", (String)"/", (boolean)false, (int)4, null)));
        String string3 = $this$possibleSourceFiles.getName();
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getName(...)");
        if (StringsKt.indexOf$default((CharSequence)string3, (String)"$", (int)0, (boolean)false, (int)6, null) != -1) {
            String string4 = $this$possibleSourceFiles.getName();
            Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"getName(...)");
            String[] stringArray = new String[]{"."};
            list.add(CollectionsKt.joinToString$default((Iterable)StringsKt.split$default((CharSequence)string4, (String[])stringArray, (boolean)false, (int)0, (int)6, null), (CharSequence)"/", null, null, (int)0, null, null, (int)62, null));
        }
        Iterable $this$flatMapTo$iv = list;
        boolean $i$f$flatMapTo = false;
        for (Object element$iv : $this$flatMapTo$iv) {
            void $this$mapTo$iv$iv;
            String src = (String)element$iv;
            boolean bl = false;
            Iterable $this$map$iv = ResourceKt.getJavaExtensions();
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void ext;
                String string5 = (String)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add(src + "." + (String)ext);
            }
            Iterable list$iv = (List)destination$iv$iv;
            CollectionsKt.addAll((Collection)res, (Iterable)list$iv);
        }
        return res;
    }

    @Nullable
    public static final Body getActiveBodyOrNull(@NotNull SootMethod $this$activeBodyOrNull) {
        Intrinsics.checkNotNullParameter((Object)$this$activeBodyOrNull, (String)"<this>");
        return $this$activeBodyOrNull.hasActiveBody() ? $this$activeBodyOrNull.getActiveBody() : null;
    }

    private static final CharSequence _get_subSignature_$lambda$2(Type it) {
        Intrinsics.checkNotNull((Object)it);
        String string = UtilsKt.getTypename((Type)it);
        Intrinsics.checkNotNull((Object)string);
        return string;
    }

    private static final SootClass findMethodOrNull$lambda$10(SootClass it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return SootUtilsKt.superClassOrNull((SootClass)it);
    }

    private static final SootClass findMethodOrNull$lambda$11(SootClass it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return SootUtilsKt.superClassOrNull((SootClass)it);
    }

    /*
     * WARNING - void declaration
     */
    private static final Iterable findMethodOrNull$lambda$13(SootClass sootClass) {
        void $this$flatMapTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)sootClass, (String)"sootClass");
        Chain chain = sootClass.getInterfaces();
        Intrinsics.checkNotNullExpressionValue((Object)chain, (String)"getInterfaces(...)");
        Iterable $this$flatMap$iv = (Iterable)chain;
        boolean $i$f$flatMap = false;
        Iterable iterable = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            SootClass it = (SootClass)element$iv$iv;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)it);
            Iterable list$iv$iv = SootUtilsKt.findAncestors((SootClass)it);
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    private static final Iterable findMethodOrNull$lambda$14(SootClass it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        List list = it.getMethods();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getMethods(...)");
        return list;
    }

    private static final boolean findMethodOrNull$lambda$15(SootClass $this_findMethodOrNull, String $params, SootMethod it) {
        if (!Intrinsics.areEqual((Object)$this_findMethodOrNull, (Object)it.getDeclaringClass())) {
            if (it.isStatic() || it.isStaticInitializer()) {
                return false;
            }
            if (it.isPrivate()) {
                return false;
            }
        }
        String string = it.getSubSignature();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getSubSignature(...)");
        return Intrinsics.areEqual((Object)StringsKt.substringAfter$default((String)string, (String)" ", null, (int)2, null), (Object)$params);
    }
}

