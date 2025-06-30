/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IndexedValue
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KCallable
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KProperty
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootField
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.BinOp;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.ClassField;
import com.feysh.corax.config.api.CustomAttributeID;
import com.feysh.corax.config.api.IAccessPathT;
import com.feysh.corax.config.api.IAttribute;
import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IIexConst;
import com.feysh.corax.config.api.IIntExpr;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.ILongExpr;
import com.feysh.corax.config.api.IOperatorFactory;
import com.feysh.corax.config.api.IStringExpr;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.ITypedExpr;
import com.feysh.corax.config.api.IViaType;
import com.feysh.corax.config.api.IWithSubFieldsT;
import com.feysh.corax.config.api.IexConstNull;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.UnOp;
import com.feysh.corax.config.api.ViaProperty;
import com.feysh.corax.config.api.baseimpl.AccessPath;
import com.feysh.corax.config.api.baseimpl.Attribute;
import com.feysh.corax.config.api.baseimpl.BinOpExpr;
import com.feysh.corax.config.api.baseimpl.BoolExpr;
import com.feysh.corax.config.api.baseimpl.IexConst;
import com.feysh.corax.config.api.baseimpl.IexGetFieldExpr;
import com.feysh.corax.config.api.baseimpl.IntExpr;
import com.feysh.corax.config.api.baseimpl.IstSetField;
import com.feysh.corax.config.api.baseimpl.LocalValue;
import com.feysh.corax.config.api.baseimpl.LongExpr;
import com.feysh.corax.config.api.baseimpl.RValue;
import com.feysh.corax.config.api.baseimpl.StringExpr;
import com.feysh.corax.config.api.baseimpl.TaintSet;
import com.feysh.corax.config.api.baseimpl.UnOpExpr;
import com.feysh.corax.config.api.baseimpl.ViaSet;
import com.feysh.corax.config.api.baseimpl.WithSubFields;
import com.feysh.corax.config.api.utils.UtilsKt;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00e8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J7\u0010\"\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000b0\tj\u0002`\u001a2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190#\"\u00020\u0019H\u0016\u00a2\u0006\u0002\u0010$J\u0014\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0013\"\u0004\b\u0000\u0010\u0004H\u0016J>\u0010&\u001a\r\u0012\t\u0012\u0007H\u0004\u00a2\u0006\u0002\b'0\u0013\"\u0004\b\u0000\u0010\u00042\u001e\u0010(\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00050#\"\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0016\u00a2\u0006\u0002\u0010)J,\u0010*\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tj\u0002`\r2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0,H\u0016J\u0018\u0010-\u001a\u00020.2\u0006\u0010-\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\u0010\u00102\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016J\u0010\u00102\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u00102\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016JS\u0010C\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002HE0D\"\b\b\u0000\u0010\u0004*\u00020F\"\u000e\b\u0001\u0010E*\b\u0012\u0004\u0012\u00020/0\u000b*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002HE0\t2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002HE0\tH\u0096\u0006JS\u0010H\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002HE0D\"\b\b\u0000\u0010\u0004*\u00020F\"\u000e\b\u0001\u0010E*\b\u0012\u0004\u0012\u00020/0\u000b*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002HE0\t2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002HE0\tH\u0096\u0006JA\u0010I\u001a\b\u0012\u0004\u0012\u0002HJ0\u0013\"\b\b\u0000\u0010K*\u0002HJ\"\b\b\u0001\u0010L*\u0002HJ\"\u0004\b\u0002\u0010J*\b\u0012\u0004\u0012\u0002HK0\u00132\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u0013H\u0096\u0004J\r\u0010N\u001a\u000203*\u000203H\u0096\u0002J\u0015\u0010O\u001a\u000203*\u0002032\u0006\u0010P\u001a\u000203H\u0096\u0004J\u0015\u0010Q\u001a\u000203*\u0002032\u0006\u0010P\u001a\u000203H\u0096\u0004J\u001c\u0010R\u001a\u000203*\u0002092\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u000209H\u0016J\u001c\u0010V\u001a\u000209*\u0002092\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u000209H\u0016J\u001c\u0010W\u001a\u000209*\u0002092\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u000209H\u0016J\u0015\u0010X\u001a\u000203*\u0002092\u0006\u0010U\u001a\u000209H\u0096\u0004J\u0015\u0010Y\u001a\u000203*\u0002092\u0006\u0010U\u001a\u000209H\u0096\u0004J\u0015\u0010Z\u001a\u000203*\u0002092\u0006\u0010U\u001a\u000209H\u0096\u0004J\u0015\u0010[\u001a\u000203*\u0002092\u0006\u0010U\u001a\u000209H\u0096\u0004J\u0015\u0010\\\u001a\u000203*\u0002092\u0006\u0010U\u001a\u000209H\u0096\u0004J\u0015\u0010]\u001a\u000203*\u0002092\u0006\u0010U\u001a\u000209H\u0096\u0004J\u0015\u0010Q\u001a\u000209*\u0002092\u0006\u0010U\u001a\u000209H\u0096\u0004J\u0015\u0010O\u001a\u000209*\u0002092\u0006\u0010U\u001a\u000209H\u0096\u0004J\u0015\u0010^\u001a\u000209*\u0002092\u0006\u0010U\u001a\u000209H\u0096\u0004J\u0015\u0010_\u001a\u000209*\u0002092\u0006\u0010U\u001a\u000209H\u0096\u0004J\u0015\u0010`\u001a\u000209*\u0002092\u0006\u0010U\u001a\u000209H\u0096\u0004J\u0015\u0010a\u001a\u000209*\u0002092\u0006\u0010U\u001a\u000209H\u0096\u0004J\u0015\u0010C\u001a\u000209*\u0002092\u0006\u0010U\u001a\u000209H\u0096\u0006J\u0015\u0010H\u001a\u000209*\u0002092\u0006\u0010U\u001a\u000209H\u0096\u0006J\u0018\u0010b\u001a\u000203\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0016J\u0018\u0010c\u001a\u000206\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0016J\u0018\u0010d\u001a\u000209\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0016J\u0018\u0010e\u001a\u00020<\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0016J\u0018\u0010f\u001a\u000206\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0016J \u0010g\u001a\u000203\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010h\u001a\u000208H\u0016J\f\u0010i\u001a\u000206*\u000206H\u0016J\u0014\u0010j\u001a\u000203*\u0002062\u0006\u0010k\u001a\u000206H\u0016J\u0014\u0010l\u001a\u000203*\u0002062\u0006\u0010k\u001a\u000206H\u0016J\u0014\u0010m\u001a\u000203*\u0002062\u0006\u0010k\u001a\u000206H\u0016J\u0014\u0010n\u001a\u000203*\u0002062\u0006\u0010k\u001a\u000206H\u0016J@\u0010o\u001a\u000203*\u0018\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tj\u0002`\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tj\u0002`\rH\u0016J@\u0010p\u001a\u000203*\u0018\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tj\u0002`\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tj\u0002`\rH\u0016J*\u0010m\u001a\u000203*\u0018\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tj\u0002`\r2\u0006\u0010\u000e\u001a\u00020\fH\u0016J:\u0010q\u001a\b\u0012\u0004\u0012\u00020/0r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\b\u0010s\u001a\u0004\u0018\u0001082\u0006\u0010t\u001a\u0002082\b\u0010u\u001a\u0004\u0018\u000108H\u0016JH\u0010q\u001a\b\u0012\u0004\u0012\u0002Hv0r\"\u0004\b\u0000\u0010\u0004\"\b\b\u0001\u0010v*\u00020/*\b\u0012\u0004\u0012\u0002H\u00040\u00052\b\u0010s\u001a\u0004\u0018\u0001082\u0006\u0010t\u001a\u0002082\f\u00100\u001a\b\u0012\u0004\u0012\u0002Hv0wH\u0016J2\u0010q\u001a\b\u0012\u0004\u0012\u0002Hx0r\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010x*\b\u0012\u0004\u0012\u0002H\u00040\u00052\f\u0010q\u001a\b\u0012\u0004\u0012\u0002Hx0yH\u0016J&\u0010q\u001a\b\u0012\u0004\u0012\u00020/0r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010q\u001a\u00020FH\u0016JB\u0010q\u001a\b\u0012\u0004\u0012\u0002Hv0r\"\u0004\b\u0000\u0010\u0004\"\b\b\u0001\u0010v*\u00020/*\b\u0012\u0004\u0012\u0002H\u00040\u00052\n\u0010q\u001a\u0006\u0012\u0002\b\u00030y2\f\u00100\u001a\b\u0012\u0004\u0012\u0002Hv0wH\u0016J4\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u0002032\"\u0010}\u001a\u001e\u0012\u0014\u0012\u001205\u00a2\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020{0~H\u0016J4\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u0002092\"\u0010}\u001a\u001e\u0012\u0014\u0012\u00120;\u00a2\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020{0~H\u0016J4\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u0002062\"\u0010}\u001a\u001e\u0012\u0014\u0012\u001208\u00a2\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020{0~H\u0016R$\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R`\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tj\u0002`\r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tj\u0002`\r8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R@\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0013\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R`\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000b0\tj\u0002`\u001a\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000b0\tj\u0002`\u001a8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u001c\u0010\u001e\u001a\u00020\u001f*\u0006\u0012\u0002\b\u00030\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R$\u0010?\u001a\u000203\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010@R\u0018\u0010?\u001a\u000203*\u00020A8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010B\u00a8\u0006\u0081\u0001"}, d2={"Lcom/feysh/corax/config/api/baseimpl/IBaseOperatorFactory;", "Lcom/feysh/corax/config/api/IOperatorFactory;", "attr", "Lcom/feysh/corax/config/api/IOperatorFactory$IAttributeGetSet;", "T", "Lcom/feysh/corax/config/api/ILocalT;", "getAttr", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IOperatorFactory$IAttributeGetSet;", "value", "Lcom/feysh/corax/config/api/IAttribute;", "Lcom/feysh/corax/config/api/TaintProperty;", "", "Lcom/feysh/corax/config/api/ITaintType;", "Lcom/feysh/corax/config/api/ITaintSet;", "taint", "getTaint", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IAttribute;", "setTaint", "(Lcom/feysh/corax/config/api/ILocalT;Lcom/feysh/corax/config/api/IAttribute;)V", "Lcom/feysh/corax/config/api/ILocalValue;", "getValue", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/ILocalValue;", "setValue", "(Lcom/feysh/corax/config/api/ILocalT;Lcom/feysh/corax/config/api/ILocalValue;)V", "Lcom/feysh/corax/config/api/ViaProperty;", "Lcom/feysh/corax/config/api/IViaType;", "Lcom/feysh/corax/config/api/IViaSet;", "via", "getVia", "setVia", "subFields", "Lcom/feysh/corax/config/api/IWithSubFieldsT;", "getSubFields", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IWithSubFieldsT;", "viaOf", "", "([Lcom/feysh/corax/config/api/IViaType;)Lcom/feysh/corax/config/api/IAttribute;", "null", "anyOf", "Lkotlin/UnsafeVariance;", "local", "([Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/ILocalValue;", "taintOf", "types", "", "const", "Lcom/feysh/corax/config/api/IExpr;", "", "type", "Lcom/feysh/corax/config/api/IIexConst$Type;", "literal", "Lcom/feysh/corax/config/api/IBoolExpr;", "bool", "", "Lcom/feysh/corax/config/api/IStringExpr;", "string", "", "Lcom/feysh/corax/config/api/IIntExpr;", "int", "", "Lcom/feysh/corax/config/api/ILongExpr;", "long", "", "isConstant", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IBoolExpr;", "Lcom/feysh/corax/config/api/ITypedExpr;", "(Lcom/feysh/corax/config/api/ITypedExpr;)Lcom/feysh/corax/config/api/IBoolExpr;", "plus", "Lcom/feysh/corax/config/api/baseimpl/Attribute;", "V", "Lcom/feysh/corax/config/api/IClassField;", "set", "minus", "anyOr", "R", "T1", "T2", "second", "not", "or", "other", "and", "compareBinOp", "op", "Lcom/feysh/corax/config/api/BinOp;", "rhs", "arithmeticBinOp", "bitwiseBinOp", "lt", "le", "eq", "ge", "gt", "neq", "xor", "shl", "shr", "lshr", "getBoolean", "getString", "getInt", "getLong", "getEnumName", "isInstanceOf", "parentType", "toLowerCase", "startsWith", "str", "endsWith", "contains", "stringEquals", "hasIntersection", "containsAll", "field", "Lcom/feysh/corax/config/api/IAccessPathT;", "declaringClass", "fieldName", "fieldType", "FieldType", "Lkotlin/reflect/KClass;", "F", "Lkotlin/reflect/KProperty;", "eval", "", "expr", "result", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "corax-config-api"})
public interface IBaseOperatorFactory
extends IOperatorFactory {
    @Override
    @NotNull
    public <T> IOperatorFactory.IAttributeGetSet getAttr(@NotNull ILocalT<T> var1);

    @Override
    @NotNull
    public <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(@NotNull ILocalT<T> var1);

    @Override
    public <T> void setTaint(@NotNull ILocalT<T> var1, @NotNull IAttribute<TaintProperty, Set<ITaintType>> var2);

    @Override
    @NotNull
    public <T> ILocalValue<T> getValue(@NotNull ILocalT<T> var1);

    @Override
    public <T> void setValue(@NotNull ILocalT<T> var1, @NotNull ILocalValue<T> var2);

    @Override
    @NotNull
    public <T> IAttribute<ViaProperty, Set<IViaType>> getVia(@NotNull ILocalT<T> var1);

    @Override
    public <T> void setVia(@NotNull ILocalT<T> var1, @NotNull IAttribute<ViaProperty, Set<IViaType>> var2);

    @Override
    @NotNull
    public IWithSubFieldsT getSubFields(@NotNull ILocalT<?> var1);

    @Override
    @NotNull
    public IAttribute<ViaProperty, Set<IViaType>> viaOf(IViaType ... var1);

    @Override
    @NotNull
    public <T> ILocalValue<T> null();

    @Override
    @NotNull
    public <T> ILocalValue<T> anyOf(ILocalT<T> ... var1);

    @Override
    @NotNull
    public IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull Collection<? extends ITaintType> var1);

    @NotNull
    public IExpr const(@NotNull Object var1, @NotNull IIexConst.Type var2);

    @Override
    @NotNull
    public IBoolExpr literal(boolean var1);

    @Override
    @NotNull
    public IStringExpr literal(@NotNull String var1);

    @Override
    @NotNull
    public IIntExpr literal(int var1);

    @Override
    @NotNull
    public ILongExpr literal(long var1);

    @Override
    @NotNull
    public <T> IBoolExpr isConstant(@NotNull ILocalT<T> var1);

    @Override
    @NotNull
    public IBoolExpr isConstant(@NotNull ITypedExpr var1);

    @NotNull
    public <T extends IClassField, V extends Set<? extends Object>> Attribute<T, V> plus(@NotNull IAttribute<T, V> var1, @NotNull IAttribute<T, V> var2);

    @NotNull
    public <T extends IClassField, V extends Set<? extends Object>> Attribute<T, V> minus(@NotNull IAttribute<T, V> var1, @NotNull IAttribute<T, V> var2);

    @Override
    @NotNull
    public <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull ILocalValue<T1> var1, @NotNull ILocalValue<T2> var2);

    @Override
    @NotNull
    public IBoolExpr not(@NotNull IBoolExpr var1);

    @Override
    @NotNull
    public IBoolExpr or(@NotNull IBoolExpr var1, @NotNull IBoolExpr var2);

    @Override
    @NotNull
    public IBoolExpr and(@NotNull IBoolExpr var1, @NotNull IBoolExpr var2);

    @NotNull
    public IBoolExpr compareBinOp(@NotNull IIntExpr var1, @NotNull BinOp var2, @NotNull IIntExpr var3);

    @NotNull
    public IIntExpr arithmeticBinOp(@NotNull IIntExpr var1, @NotNull BinOp var2, @NotNull IIntExpr var3);

    @NotNull
    public IIntExpr bitwiseBinOp(@NotNull IIntExpr var1, @NotNull BinOp var2, @NotNull IIntExpr var3);

    @Override
    @NotNull
    public IBoolExpr lt(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @Override
    @NotNull
    public IBoolExpr le(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @Override
    @NotNull
    public IBoolExpr eq(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @Override
    @NotNull
    public IBoolExpr ge(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @Override
    @NotNull
    public IBoolExpr gt(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @Override
    @NotNull
    public IBoolExpr neq(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @Override
    @NotNull
    public IIntExpr and(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @Override
    @NotNull
    public IIntExpr or(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @Override
    @NotNull
    public IIntExpr xor(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @Override
    @NotNull
    public IIntExpr shl(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @Override
    @NotNull
    public IIntExpr shr(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @Override
    @NotNull
    public IIntExpr lshr(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @Override
    @NotNull
    public IIntExpr plus(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @Override
    @NotNull
    public IIntExpr minus(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @Override
    @NotNull
    public <T> IBoolExpr getBoolean(@NotNull ILocalT<T> var1);

    @Override
    @NotNull
    public <T> IStringExpr getString(@NotNull ILocalT<T> var1);

    @Override
    @NotNull
    public <T> IIntExpr getInt(@NotNull ILocalT<T> var1);

    @Override
    @NotNull
    public <T> ILongExpr getLong(@NotNull ILocalT<T> var1);

    @Override
    @NotNull
    public <T> IStringExpr getEnumName(@NotNull ILocalT<T> var1);

    @Override
    @NotNull
    public <T> IBoolExpr isInstanceOf(@NotNull ILocalT<T> var1, @NotNull String var2);

    @Override
    @NotNull
    public IStringExpr toLowerCase(@NotNull IStringExpr var1);

    @Override
    @NotNull
    public IBoolExpr startsWith(@NotNull IStringExpr var1, @NotNull IStringExpr var2);

    @Override
    @NotNull
    public IBoolExpr endsWith(@NotNull IStringExpr var1, @NotNull IStringExpr var2);

    @Override
    @NotNull
    public IBoolExpr contains(@NotNull IStringExpr var1, @NotNull IStringExpr var2);

    @Override
    @NotNull
    public IBoolExpr stringEquals(@NotNull IStringExpr var1, @NotNull IStringExpr var2);

    @Override
    @NotNull
    public IBoolExpr hasIntersection(@NotNull IAttribute<TaintProperty, Set<ITaintType>> var1, @NotNull IAttribute<TaintProperty, Set<ITaintType>> var2);

    @Override
    @NotNull
    public IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> var1, @NotNull IAttribute<TaintProperty, Set<ITaintType>> var2);

    @Override
    @NotNull
    public IBoolExpr contains(@NotNull IAttribute<TaintProperty, Set<ITaintType>> var1, @NotNull ITaintType var2);

    @Override
    @NotNull
    public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> var1, @Nullable String var2, @NotNull String var3, @Nullable String var4);

    @Override
    @NotNull
    public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> var1, @Nullable String var2, @NotNull String var3, @NotNull KClass<FieldType> var4);

    @Override
    @NotNull
    public <T, F> IAccessPathT<F> field(@NotNull ILocalT<T> var1, @NotNull KProperty<? extends F> var2);

    @Override
    @NotNull
    public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> var1, @NotNull IClassField var2);

    @Override
    @NotNull
    public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> var1, @NotNull KProperty<?> var2, @NotNull KClass<FieldType> var3);

    @Override
    public void eval(@NotNull IBoolExpr var1, @NotNull Function1<? super Boolean, Unit> var2);

    @Override
    public void eval(@NotNull IIntExpr var1, @NotNull Function1<? super Integer, Unit> var2);

    @Override
    public void eval(@NotNull IStringExpr var1, @NotNull Function1<? super String, Unit> var2);

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @NotNull
        public static <T> IOperatorFactory.IAttributeGetSet getAttr(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            return new IOperatorFactory.IAttributeGetSet($receiver, $this){
                final /* synthetic */ ILocalT<T> $this_attr;
                final /* synthetic */ IBaseOperatorFactory this$0;
                {
                    this.$this_attr = $receiver;
                    this.this$0 = $receiver2;
                }

                public <T> IAccessPathT<T> get(CustomAttributeID<T> id) {
                    Intrinsics.checkNotNullParameter(id, (String)"id");
                    return new AccessPath<T>(this.$this_attr.getExpr(), id.getAttributeName());
                }

                public final <T> void setAny(CustomAttributeID<T> id, IExpr value) {
                    Intrinsics.checkNotNullParameter(id, (String)"id");
                    Intrinsics.checkNotNullParameter((Object)value, (String)"value");
                    this.this$0.addStmt(new IstSetField(this.$this_attr.getExpr(), id.getAttributeName(), value));
                }

                public <T> void set(CustomAttributeID<T> id, ILocalValue<T> value) {
                    Intrinsics.checkNotNullParameter(id, (String)"id");
                    Intrinsics.checkNotNullParameter(value, (String)"value");
                    this.setAny(id, value.getRvalue());
                }

                public void set(CustomAttributeID<Boolean> id, boolean value) {
                    Intrinsics.checkNotNullParameter(id, (String)"id");
                    this.setAny(id, this.this$0.const(value, IIexConst.Type.Boolean));
                }

                public void set(CustomAttributeID<Short> id, short value) {
                    Intrinsics.checkNotNullParameter(id, (String)"id");
                    this.setAny(id, this.this$0.const(value, IIexConst.Type.Short));
                }

                public void set(CustomAttributeID<Integer> id, int value) {
                    Intrinsics.checkNotNullParameter(id, (String)"id");
                    this.setAny(id, this.this$0.const(value, IIexConst.Type.Int));
                }

                public void set(CustomAttributeID<Long> id, long value) {
                    Intrinsics.checkNotNullParameter(id, (String)"id");
                    this.setAny(id, this.this$0.const(value, IIexConst.Type.Long));
                }

                public void set(CustomAttributeID<String> id, String value) {
                    Intrinsics.checkNotNullParameter(id, (String)"id");
                    Intrinsics.checkNotNullParameter((Object)value, (String)"value");
                    this.setAny(id, this.this$0.const(value, IIexConst.Type.String));
                }

                public <T> void set(CustomAttributeID<T> id, ITypedExpr value) {
                    Intrinsics.checkNotNullParameter(id, (String)"id");
                    Intrinsics.checkNotNullParameter((Object)value, (String)"value");
                    this.setAny(id, value.getExpr());
                }
            };
        }

        @NotNull
        public static <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            return new TaintSet(new UnOpExpr(UnOp.GetSet, IexGetFieldExpr.Companion.invoke($receiver.getExpr(), TaintProperty.INSTANCE)));
        }

        public static <T> void setTaint(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver, @NotNull IAttribute<TaintProperty, Set<ITaintType>> value) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter(value, (String)"value");
            $this.addStmt(new IstSetField($receiver.getExpr(), TaintProperty.INSTANCE, value.getValue()));
        }

        @NotNull
        public static <T> ILocalValue<T> getValue(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            return new LocalValue<T>($receiver);
        }

        public static <T> void setValue(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver, @NotNull ILocalValue<T> value) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter(value, (String)"value");
            $this.addStmt(new LocalValue<T>($receiver).setValue(value.getRvalue()));
        }

        @NotNull
        public static <T> IAttribute<ViaProperty, Set<IViaType>> getVia(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            return new ViaSet(new UnOpExpr(UnOp.GetSet, IexGetFieldExpr.Companion.invoke($receiver.getExpr(), ViaProperty.INSTANCE)));
        }

        public static <T> void setVia(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver, @NotNull IAttribute<ViaProperty, Set<IViaType>> value) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter(value, (String)"value");
            $this.addStmt(new IstSetField($receiver.getExpr(), ViaProperty.INSTANCE, value.getValue()));
        }

        @NotNull
        public static IWithSubFieldsT getSubFields(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<?> $receiver) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            return new WithSubFields($receiver.getExpr());
        }

        @NotNull
        public static IAttribute<ViaProperty, Set<IViaType>> viaOf(@NotNull IBaseOperatorFactory $this, IViaType ... via) {
            Intrinsics.checkNotNullParameter((Object)via, (String)"via");
            return new ViaSet($this.const(ArraysKt.toSet((Object[])via), IIexConst.Type.ViaSet));
        }

        @NotNull
        public static <T> ILocalValue<T> null(@NotNull IBaseOperatorFactory $this) {
            return new RValue($this.const(SetsKt.setOf((Object)IexConstNull.INSTANCE), IIexConst.Type.NULL));
        }

        @NotNull
        public static <T> ILocalValue<T> anyOf(@NotNull IBaseOperatorFactory $this, ILocalT<T> ... local) {
            Intrinsics.checkNotNullParameter(local, (String)"local");
            IExpr expr = null;
            for (IndexedValue i : ArraysKt.withIndex((Object[])local)) {
                IExpr iExpr;
                if (i.getIndex() != 0) {
                    IExpr iExpr2 = expr;
                    Intrinsics.checkNotNull((Object)iExpr2);
                    iExpr = new BinOpExpr(BinOp.AnyOf, iExpr2, ((ILocalT)i.getValue()).getExpr());
                } else {
                    iExpr = ((ILocalT)ArraysKt.first((Object[])local)).getExpr();
                }
                expr = iExpr;
            }
            if (expr == null) {
                expr = $this.const(SetsKt.emptySet(), IIexConst.Type.EmptyElement);
            }
            return new RValue(expr);
        }

        @NotNull
        public static IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull IBaseOperatorFactory $this, @NotNull Collection<? extends ITaintType> types) {
            Intrinsics.checkNotNullParameter(types, (String)"types");
            return new TaintSet($this.const(CollectionsKt.toSet((Iterable)types), IIexConst.Type.TaintSet));
        }

        @NotNull
        public static IExpr const(@NotNull IBaseOperatorFactory $this, @NotNull Object object, @NotNull IIexConst.Type type) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"const");
            Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
            return new IexConst(object, type);
        }

        @NotNull
        public static IBoolExpr literal(@NotNull IBaseOperatorFactory $this, boolean bool) {
            return new BoolExpr($this.const(bool, IIexConst.Type.Boolean));
        }

        @NotNull
        public static IStringExpr literal(@NotNull IBaseOperatorFactory $this, @NotNull String string) {
            Intrinsics.checkNotNullParameter((Object)string, (String)"string");
            return new StringExpr($this.const(string, IIexConst.Type.String));
        }

        @NotNull
        public static IIntExpr literal(@NotNull IBaseOperatorFactory $this, int n) {
            return new IntExpr($this.const(n, IIexConst.Type.Int));
        }

        @NotNull
        public static ILongExpr literal(@NotNull IBaseOperatorFactory $this, long l) {
            return new LongExpr($this.const(l, IIexConst.Type.Long));
        }

        @NotNull
        public static <T> IBoolExpr isConstant(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            return new BoolExpr(new UnOpExpr(UnOp.IsConstant, $receiver.getExpr()));
        }

        @NotNull
        public static IBoolExpr isConstant(@NotNull IBaseOperatorFactory $this, @NotNull ITypedExpr $receiver) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            return new BoolExpr(new UnOpExpr(UnOp.IsConstant, $receiver.getExpr()));
        }

        @NotNull
        public static <T extends IClassField, V extends Set<? extends Object>> Attribute<T, V> plus(@NotNull IBaseOperatorFactory $this, @NotNull IAttribute<T, V> $receiver, @NotNull IAttribute<T, V> set) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter(set, (String)"set");
            return new Attribute(new BinOpExpr(BinOp.OrSet, $receiver.getValue(), set.getValue()));
        }

        @NotNull
        public static <T extends IClassField, V extends Set<? extends Object>> Attribute<T, V> minus(@NotNull IBaseOperatorFactory $this, @NotNull IAttribute<T, V> $receiver, @NotNull IAttribute<T, V> set) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter(set, (String)"set");
            return new Attribute(new BinOpExpr(BinOp.RemoveSet, $receiver.getValue(), set.getValue()));
        }

        @NotNull
        public static <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull IBaseOperatorFactory $this, @NotNull ILocalValue<T1> $receiver, @NotNull ILocalValue<T2> second) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter(second, (String)"second");
            return new RValue(new BinOpExpr(BinOp.AnyOf, $receiver.getRvalue(), second.getRvalue()));
        }

        @NotNull
        public static IBoolExpr not(@NotNull IBaseOperatorFactory $this, @NotNull IBoolExpr $receiver) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            return new BoolExpr(new UnOpExpr(UnOp.Not, $receiver.getExpr()));
        }

        @NotNull
        public static IBoolExpr or(@NotNull IBaseOperatorFactory $this, @NotNull IBoolExpr $receiver, @NotNull IBoolExpr other) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)other, (String)"other");
            return new BoolExpr(new BinOpExpr(BinOp.Or, $receiver.getExpr(), other.getExpr()));
        }

        @NotNull
        public static IBoolExpr and(@NotNull IBaseOperatorFactory $this, @NotNull IBoolExpr $receiver, @NotNull IBoolExpr other) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)other, (String)"other");
            return new BoolExpr(new BinOpExpr(BinOp.And, $receiver.getExpr(), other.getExpr()));
        }

        @NotNull
        public static IBoolExpr compareBinOp(@NotNull IBaseOperatorFactory $this, @NotNull IIntExpr $receiver, @NotNull BinOp op, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)((Object)op), (String)"op");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return new BoolExpr(new BinOpExpr(op, $receiver.getExpr(), rhs.getExpr()));
        }

        @NotNull
        public static IIntExpr arithmeticBinOp(@NotNull IBaseOperatorFactory $this, @NotNull IIntExpr $receiver, @NotNull BinOp op, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)((Object)op), (String)"op");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return new IntExpr(new BinOpExpr(op, $receiver.getExpr(), rhs.getExpr()));
        }

        @NotNull
        public static IIntExpr bitwiseBinOp(@NotNull IBaseOperatorFactory $this, @NotNull IIntExpr $receiver, @NotNull BinOp op, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)((Object)op), (String)"op");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return new IntExpr(new BinOpExpr(op, $receiver.getExpr(), rhs.getExpr()));
        }

        @NotNull
        public static IBoolExpr lt(@NotNull IBaseOperatorFactory $this, @NotNull IIntExpr $receiver, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return $this.compareBinOp($receiver, BinOp.LT, rhs);
        }

        @NotNull
        public static IBoolExpr le(@NotNull IBaseOperatorFactory $this, @NotNull IIntExpr $receiver, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return $this.compareBinOp($receiver, BinOp.LE, rhs);
        }

        @NotNull
        public static IBoolExpr eq(@NotNull IBaseOperatorFactory $this, @NotNull IIntExpr $receiver, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return $this.compareBinOp($receiver, BinOp.EQ, rhs);
        }

        @NotNull
        public static IBoolExpr ge(@NotNull IBaseOperatorFactory $this, @NotNull IIntExpr $receiver, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return $this.compareBinOp($receiver, BinOp.GE, rhs);
        }

        @NotNull
        public static IBoolExpr gt(@NotNull IBaseOperatorFactory $this, @NotNull IIntExpr $receiver, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return $this.compareBinOp($receiver, BinOp.GT, rhs);
        }

        @NotNull
        public static IBoolExpr neq(@NotNull IBaseOperatorFactory $this, @NotNull IIntExpr $receiver, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return $this.not($this.compareBinOp($receiver, BinOp.EQ, rhs));
        }

        @NotNull
        public static IIntExpr and(@NotNull IBaseOperatorFactory $this, @NotNull IIntExpr $receiver, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return $this.bitwiseBinOp($receiver, BinOp.BvAnd, rhs);
        }

        @NotNull
        public static IIntExpr or(@NotNull IBaseOperatorFactory $this, @NotNull IIntExpr $receiver, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return $this.bitwiseBinOp($receiver, BinOp.BvOr, rhs);
        }

        @NotNull
        public static IIntExpr xor(@NotNull IBaseOperatorFactory $this, @NotNull IIntExpr $receiver, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return $this.bitwiseBinOp($receiver, BinOp.BvXor, rhs);
        }

        @NotNull
        public static IIntExpr shl(@NotNull IBaseOperatorFactory $this, @NotNull IIntExpr $receiver, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return $this.bitwiseBinOp($receiver, BinOp.BvShl, rhs);
        }

        @NotNull
        public static IIntExpr shr(@NotNull IBaseOperatorFactory $this, @NotNull IIntExpr $receiver, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return $this.bitwiseBinOp($receiver, BinOp.BvShr, rhs);
        }

        @NotNull
        public static IIntExpr lshr(@NotNull IBaseOperatorFactory $this, @NotNull IIntExpr $receiver, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return $this.bitwiseBinOp($receiver, BinOp.BvLShr, rhs);
        }

        @NotNull
        public static IIntExpr plus(@NotNull IBaseOperatorFactory $this, @NotNull IIntExpr $receiver, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return $this.arithmeticBinOp($receiver, BinOp.Add, rhs);
        }

        @NotNull
        public static IIntExpr minus(@NotNull IBaseOperatorFactory $this, @NotNull IIntExpr $receiver, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return $this.arithmeticBinOp($receiver, BinOp.Sub, rhs);
        }

        @NotNull
        public static <T> IBoolExpr getBoolean(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            return new BoolExpr(new UnOpExpr(UnOp.GetBoolean, $receiver.getExpr()));
        }

        @NotNull
        public static <T> IStringExpr getString(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            return new StringExpr(new UnOpExpr(UnOp.GetString, $receiver.getExpr()));
        }

        @NotNull
        public static <T> IIntExpr getInt(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            return new IntExpr(new UnOpExpr(UnOp.GetInt, $receiver.getExpr()));
        }

        @NotNull
        public static <T> ILongExpr getLong(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            return new LongExpr(new UnOpExpr(UnOp.GetLong, $receiver.getExpr()));
        }

        @NotNull
        public static <T> IStringExpr getEnumName(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            return new StringExpr(new UnOpExpr(UnOp.GetEnumName, $receiver.getExpr()));
        }

        @NotNull
        public static <T> IBoolExpr isInstanceOf(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver, @NotNull String parentType) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)parentType, (String)"parentType");
            return new BoolExpr(new BinOpExpr(BinOp.IsInstanceOf, $receiver.getExpr(), $this.const(parentType, IIexConst.Type.Class)));
        }

        @NotNull
        public static IStringExpr toLowerCase(@NotNull IBaseOperatorFactory $this, @NotNull IStringExpr $receiver) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            return new StringExpr(new UnOpExpr(UnOp.ToLowerCase, $receiver.getExpr()));
        }

        @NotNull
        public static IBoolExpr startsWith(@NotNull IBaseOperatorFactory $this, @NotNull IStringExpr $receiver, @NotNull IStringExpr str) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return new BoolExpr(new BinOpExpr(BinOp.StartsWith, $receiver.getExpr(), str.getExpr()));
        }

        @NotNull
        public static IBoolExpr endsWith(@NotNull IBaseOperatorFactory $this, @NotNull IStringExpr $receiver, @NotNull IStringExpr str) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return new BoolExpr(new BinOpExpr(BinOp.EndsWith, $receiver.getExpr(), str.getExpr()));
        }

        @NotNull
        public static IBoolExpr contains(@NotNull IBaseOperatorFactory $this, @NotNull IStringExpr $receiver, @NotNull IStringExpr str) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return new BoolExpr(new BinOpExpr(BinOp.Contains, $receiver.getExpr(), str.getExpr()));
        }

        @NotNull
        public static IBoolExpr stringEquals(@NotNull IBaseOperatorFactory $this, @NotNull IStringExpr $receiver, @NotNull IStringExpr str) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return new BoolExpr(new BinOpExpr(BinOp.StringEquals, $receiver.getExpr(), str.getExpr()));
        }

        @NotNull
        public static IBoolExpr hasIntersection(@NotNull IBaseOperatorFactory $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull IAttribute<TaintProperty, Set<ITaintType>> taint) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter(taint, (String)"taint");
            BinOpExpr expr = new BinOpExpr(BinOp.HasIntersectionSet, $receiver.getValue(), taint.getValue());
            return new BoolExpr(expr);
        }

        @NotNull
        public static IBoolExpr containsAll(@NotNull IBaseOperatorFactory $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull IAttribute<TaintProperty, Set<ITaintType>> taint) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter(taint, (String)"taint");
            BinOpExpr expr = new BinOpExpr(BinOp.ContainsSet, $receiver.getValue(), taint.getValue());
            return new BoolExpr(expr);
        }

        @NotNull
        public static IBoolExpr contains(@NotNull IBaseOperatorFactory $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType taint) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
            ITaintType[] iTaintTypeArray = new ITaintType[]{taint};
            return $this.containsAll($receiver, $this.taintOf(iTaintTypeArray));
        }

        @NotNull
        public static <T> IAccessPathT<Object> field(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver, @Nullable String declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            return new AccessPath($receiver.getExpr(), new ClassField(declaringClass, fieldName, fieldType));
        }

        @NotNull
        public static <T, FieldType> IAccessPathT<FieldType> field(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver, @Nullable String declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            Intrinsics.checkNotNullParameter(type, (String)"type");
            return new AccessPath($receiver.getExpr(), new ClassField(declaringClass, fieldName, UtilsKt.getSootTypeName(type)));
        }

        @NotNull
        public static <T, F> IAccessPathT<F> field(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver, @NotNull KProperty<? extends F> field) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter(field, (String)"field");
            return new AccessPath($receiver.getExpr(), new ClassField(field));
        }

        @NotNull
        public static <T> IAccessPathT<Object> field(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver, @NotNull IClassField field) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)field, (String)"field");
            return new AccessPath($receiver.getExpr(), field);
        }

        @NotNull
        public static <T, FieldType> IAccessPathT<FieldType> field(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver, @NotNull KProperty<?> field, @NotNull KClass<FieldType> type) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter(field, (String)"field");
            Intrinsics.checkNotNullParameter(type, (String)"type");
            return new AccessPath($receiver.getExpr(), new ClassField(UtilsKt.getDeclaringClassName((KCallable)field), field.getName(), UtilsKt.getSootTypeName(type)));
        }

        public static void eval(@NotNull IBaseOperatorFactory $this, @NotNull IBoolExpr expr, @NotNull Function1<? super Boolean, Unit> result) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter(result, (String)"result");
            $this.eval(expr.getExpr(), (Function1<Object, Unit>)((Function1)arg_0 -> DefaultImpls.eval$lambda$0(result, arg_0)));
        }

        public static void eval(@NotNull IBaseOperatorFactory $this, @NotNull IIntExpr expr, @NotNull Function1<? super Integer, Unit> result) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter(result, (String)"result");
            $this.eval(expr.getExpr(), (Function1<Object, Unit>)((Function1)arg_0 -> DefaultImpls.eval$lambda$1(result, arg_0)));
        }

        public static void eval(@NotNull IBaseOperatorFactory $this, @NotNull IStringExpr expr, @NotNull Function1<? super String, Unit> result) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter(result, (String)"result");
            $this.eval(expr.getExpr(), (Function1<Object, Unit>)((Function1)arg_0 -> DefaultImpls.eval$lambda$2(result, arg_0)));
        }

        @NotNull
        public static IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IBaseOperatorFactory $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            return IOperatorFactory.DefaultImpls.plus((IOperatorFactory)$this, $receiver, single);
        }

        @NotNull
        public static IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IBaseOperatorFactory $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            return IOperatorFactory.DefaultImpls.plus((IOperatorFactory)$this, $receiver, single);
        }

        @NotNull
        public static IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IBaseOperatorFactory $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            return IOperatorFactory.DefaultImpls.minus((IOperatorFactory)$this, $receiver, single);
        }

        @NotNull
        public static IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IBaseOperatorFactory $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            return IOperatorFactory.DefaultImpls.minus((IOperatorFactory)$this, $receiver, single);
        }

        @NotNull
        public static IBoolExpr startsWith(@NotNull IBaseOperatorFactory $this, @NotNull IStringExpr $receiver, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return IOperatorFactory.DefaultImpls.startsWith($this, $receiver, str);
        }

        @NotNull
        public static IBoolExpr endsWith(@NotNull IBaseOperatorFactory $this, @NotNull IStringExpr $receiver, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return IOperatorFactory.DefaultImpls.endsWith($this, $receiver, str);
        }

        @NotNull
        public static IBoolExpr contains(@NotNull IBaseOperatorFactory $this, @NotNull IStringExpr $receiver, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return IOperatorFactory.DefaultImpls.contains($this, $receiver, str);
        }

        @NotNull
        public static IBoolExpr stringEquals(@NotNull IBaseOperatorFactory $this, @NotNull IStringExpr $receiver, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return IOperatorFactory.DefaultImpls.stringEquals($this, $receiver, str);
        }

        @NotNull
        public static IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull IBaseOperatorFactory $this, ITaintType ... type) {
            Intrinsics.checkNotNullParameter((Object)type, (String)"type");
            return IOperatorFactory.DefaultImpls.taintOf($this, type);
        }

        @NotNull
        public static IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint(@NotNull IBaseOperatorFactory $this) {
            return IOperatorFactory.DefaultImpls.getEmptyTaint($this);
        }

        @NotNull
        public static IAttribute<ViaProperty, Set<IViaType>> getEmptyVia(@NotNull IBaseOperatorFactory $this) {
            return IOperatorFactory.DefaultImpls.getEmptyVia($this);
        }

        @NotNull
        public static IBoolExpr containsAll(@NotNull IBaseOperatorFactory $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType taint) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
            return IOperatorFactory.DefaultImpls.containsAll($this, $receiver, taint);
        }

        @NotNull
        public static <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T1> $receiver, @NotNull ILocalT<T2> second) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter(second, (String)"second");
            return IOperatorFactory.DefaultImpls.anyOr($this, $receiver, second);
        }

        @NotNull
        public static <T> IAccessPathT<Object> field(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver, @NotNull SootField field) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)field, (String)"field");
            return IOperatorFactory.DefaultImpls.field($this, $receiver, field);
        }

        @NotNull
        public static <T, FieldType> IAccessPathT<FieldType> field(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            Intrinsics.checkNotNullParameter(type, (String)"type");
            return IOperatorFactory.DefaultImpls.field((IOperatorFactory)$this, $receiver, declaringClass, fieldName, type);
        }

        @NotNull
        public static <T> IAccessPathT<Object> field(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<T> $receiver, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            return IOperatorFactory.DefaultImpls.field((IOperatorFactory)$this, $receiver, declaringClass, fieldName, fieldType);
        }

        public static void check(@NotNull IBaseOperatorFactory $this, @NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
            Intrinsics.checkNotNullParameter(expr, (String)"expr");
            Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
            Intrinsics.checkNotNullParameter(env, (String)"env");
            IOperatorFactory.DefaultImpls.check($this, expr, checkType, env);
        }

        private static Unit eval$lambda$0(Function1 $result, Object it) {
            block0: {
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Boolean bl = it instanceof Boolean ? (Boolean)it : null;
                if (bl == null) break block0;
                Boolean bl2 = bl;
                $result.invoke((Object)bl2);
            }
            return Unit.INSTANCE;
        }

        private static Unit eval$lambda$1(Function1 $result, Object it) {
            block0: {
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Integer n = it instanceof Integer ? (Integer)it : null;
                if (n == null) break block0;
                Integer n2 = n;
                $result.invoke((Object)n2);
            }
            return Unit.INSTANCE;
        }

        private static Unit eval$lambda$2(Function1 $result, Object it) {
            block0: {
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                String string = it instanceof String ? (String)it : null;
                if (string == null) break block0;
                String string2 = string;
                $result.invoke((Object)string2);
            }
            return Unit.INSTANCE;
        }
    }
}

