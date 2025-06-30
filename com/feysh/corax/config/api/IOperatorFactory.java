/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KProperty
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootField
 *  soot.Type
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.CustomAttributeID;
import com.feysh.corax.config.api.IAccessPathT;
import com.feysh.corax.config.api.IAttribute;
import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IIntExpr;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.ILongExpr;
import com.feysh.corax.config.api.IStmt;
import com.feysh.corax.config.api.IStringExpr;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.ITypedExpr;
import com.feysh.corax.config.api.IViaType;
import com.feysh.corax.config.api.IWithSubFieldsT;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.ViaProperty;
import com.feysh.corax.config.api.utils.UtilsKt;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import soot.Type;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00ec\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0089\u0001J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H&J\u0010\u0010\"\u001a\u00020&2\u0006\u0010'\u001a\u00020(H&J\u0010\u0010\"\u001a\u00020)2\u0006\u0010*\u001a\u00020+H&J\u0010\u0010\"\u001a\u00020,2\u0006\u0010-\u001a\u00020.H&J\r\u00103\u001a\u00020,*\u00020,H\u00a6\u0002J\u0015\u00104\u001a\u00020,*\u00020,2\u0006\u00105\u001a\u00020,H\u00a6\u0004J\u0015\u00106\u001a\u00020,*\u00020,2\u0006\u00105\u001a\u00020,H\u00a6\u0004J\u0015\u00107\u001a\u00020,*\u00020&2\u0006\u00108\u001a\u00020&H\u00a6\u0004J\u0015\u00109\u001a\u00020,*\u00020&2\u0006\u00108\u001a\u00020&H\u00a6\u0004J\u0015\u0010:\u001a\u00020,*\u00020&2\u0006\u00108\u001a\u00020&H\u00a6\u0004J\u0015\u0010;\u001a\u00020,*\u00020&2\u0006\u00108\u001a\u00020&H\u00a6\u0004J\u0015\u0010<\u001a\u00020,*\u00020&2\u0006\u00108\u001a\u00020&H\u00a6\u0004J\u0015\u0010=\u001a\u00020,*\u00020&2\u0006\u00108\u001a\u00020&H\u00a6\u0004J\u0015\u00106\u001a\u00020&*\u00020&2\u0006\u00108\u001a\u00020&H\u00a6\u0004J\u0015\u00104\u001a\u00020&*\u00020&2\u0006\u00108\u001a\u00020&H\u00a6\u0004J\u0015\u0010>\u001a\u00020&*\u00020&2\u0006\u00108\u001a\u00020&H\u00a6\u0004J\u0015\u0010?\u001a\u00020&*\u00020&2\u0006\u00108\u001a\u00020&H\u00a6\u0004J\u0015\u0010@\u001a\u00020&*\u00020&2\u0006\u00108\u001a\u00020&H\u00a6\u0004J\u0015\u0010A\u001a\u00020&*\u00020&2\u0006\u00108\u001a\u00020&H\u00a6\u0004J\u0015\u0010B\u001a\u00020&*\u00020&2\u0006\u00108\u001a\u00020&H\u00a6\u0002J\u0015\u0010C\u001a\u00020&*\u00020&2\u0006\u00108\u001a\u00020&H\u00a6\u0002J\u0018\u0010D\u001a\u00020,\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0004H&J\u0018\u0010E\u001a\u00020#\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0004H&J\u0018\u0010F\u001a\u00020&\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0004H&J\u0018\u0010G\u001a\u00020)\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0004H&J\u0018\u0010H\u001a\u00020#\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0004H&J \u0010I\u001a\u00020,\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00042\u0006\u0010J\u001a\u00020%H&J\f\u0010K\u001a\u00020#*\u00020#H&J\u0014\u0010L\u001a\u00020,*\u00020#2\u0006\u0010M\u001a\u00020#H&J\u0014\u0010L\u001a\u00020,*\u00020#2\u0006\u0010M\u001a\u00020%H\u0016J\u0014\u0010N\u001a\u00020,*\u00020#2\u0006\u0010M\u001a\u00020#H&J\u0014\u0010N\u001a\u00020,*\u00020#2\u0006\u0010M\u001a\u00020%H\u0016J\u0014\u0010O\u001a\u00020,*\u00020#2\u0006\u0010M\u001a\u00020#H&J\u0014\u0010O\u001a\u00020,*\u00020#2\u0006\u0010M\u001a\u00020%H\u0016J\u0014\u0010P\u001a\u00020,*\u00020#2\u0006\u0010M\u001a\u00020#H&J\u0014\u0010P\u001a\u00020,*\u00020#2\u0006\u0010M\u001a\u00020%H\u0016J7\u0010Q\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\rj\u0002`\u00112\u0012\u0010R\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100S\"\u00020\u0010H\u0016\u00a2\u0006\u0002\u0010TJ,\u0010Q\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\rj\u0002`\u00112\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00100VH&J7\u0010W\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000f0\rj\u0002`\u00192\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180S\"\u00020\u0018H&\u00a2\u0006\u0002\u0010XJ>\u0010^\u001a\r\u0012\t\u0012\u0007H\t\u00a2\u0006\u0002\b_0\u001d\"\u0004\b\u0000\u0010\t2\u001e\u0010`\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\t0\u00040S\"\b\u0012\u0004\u0012\u0002H\t0\u0004H&\u00a2\u0006\u0002\u0010aJ\u0014\u0010b\u001a\b\u0012\u0004\u0012\u0002H\t0\u001d\"\u0004\b\u0000\u0010\tH&J@\u0010c\u001a\u00020,*\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\rj\u0002`\u00112\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\rj\u0002`\u0011H&J*\u0010O\u001a\u00020,*\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\rj\u0002`\u00112\u0006\u0010\f\u001a\u00020\u0010H&J*\u0010d\u001a\u00020,*\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\rj\u0002`\u00112\u0006\u0010\f\u001a\u00020\u0010H\u0016J@\u0010d\u001a\u00020,*\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\rj\u0002`\u00112\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\rj\u0002`\u0011H&JS\u0010B\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002He0\r\"\b\b\u0000\u0010\t*\u00020f\"\u000e\b\u0001\u0010e*\b\u0012\u0004\u0012\u00020\u00010\u000f*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002He0\r2\u0012\u0010g\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002He0\rH\u00a6\u0006JS\u0010C\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002He0\r\"\b\b\u0000\u0010\t*\u00020f\"\u000e\b\u0001\u0010e*\b\u0012\u0004\u0012\u00020\u00010\u000f*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002He0\r2\u0012\u0010g\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002He0\rH\u00a6\u0006JA\u0010B\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\rj\u0002`\u0011*\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\rj\u0002`\u00112\u0006\u0010h\u001a\u00020\u0010H\u0096\u0006JA\u0010C\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\rj\u0002`\u0011*\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\rj\u0002`\u00112\u0006\u0010h\u001a\u00020\u0010H\u0096\u0006JA\u0010B\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000f0\rj\u0002`\u0019*\u0018\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000f0\rj\u0002`\u00192\u0006\u0010h\u001a\u00020\u0018H\u0096\u0006JA\u0010C\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000f0\rj\u0002`\u0019*\u0018\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000f0\rj\u0002`\u00192\u0006\u0010h\u001a\u00020\u0018H\u0096\u0006JA\u0010i\u001a\b\u0012\u0004\u0012\u0002Hj0\u001d\"\b\b\u0000\u0010k*\u0002Hj\"\b\b\u0001\u0010l*\u0002Hj\"\u0004\b\u0002\u0010j*\b\u0012\u0004\u0012\u0002Hk0\u001d2\f\u0010m\u001a\b\u0012\u0004\u0012\u0002Hl0\u001dH\u00a6\u0004JA\u0010i\u001a\b\u0012\u0004\u0012\u0002Hj0\u001d\"\b\b\u0000\u0010k*\u0002Hj\"\b\b\u0001\u0010l*\u0002Hj\"\u0004\b\u0002\u0010j*\b\u0012\u0004\u0012\u0002Hk0\u00042\f\u0010m\u001a\b\u0012\u0004\u0012\u0002Hl0\u0004H\u0096\u0004J<\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00010o\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00042\b\u0010p\u001a\u0004\u0018\u00010%2\u0006\u0010q\u001a\u00020%2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010%H&J&\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00010o\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00042\u0006\u0010n\u001a\u00020sH\u0016JH\u0010n\u001a\b\u0012\u0004\u0012\u0002Ht0o\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010t*\u00020\u0001*\b\u0012\u0004\u0012\u0002H\t0\u00042\b\u0010p\u001a\u0004\u0018\u00010%2\u0006\u0010q\u001a\u00020%2\f\u0010R\u001a\b\u0012\u0004\u0012\u0002Ht0uH&JL\u0010n\u001a\b\u0012\u0004\u0012\u0002Ht0o\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010t*\u00020\u0001*\b\u0012\u0004\u0012\u0002H\t0\u00042\f\u0010p\u001a\b\u0012\u0002\b\u0003\u0018\u00010u2\u0006\u0010q\u001a\u00020%2\f\u0010R\u001a\b\u0012\u0004\u0012\u0002Ht0uH\u0016J>\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00010o\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00042\n\u0010p\u001a\u0006\u0012\u0002\b\u00030u2\u0006\u0010q\u001a\u00020%2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010%H\u0016J&\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00010o\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00042\u0006\u0010n\u001a\u00020fH&J2\u0010n\u001a\b\u0012\u0004\u0012\u0002Hv0o\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010v*\b\u0012\u0004\u0012\u0002H\t0\u00042\f\u0010n\u001a\b\u0012\u0004\u0012\u0002Hv0wH&JB\u0010n\u001a\b\u0012\u0004\u0012\u0002Ht0o\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010t*\u00020\u0001*\b\u0012\u0004\u0012\u0002H\t0\u00042\n\u0010n\u001a\u0006\u0012\u0002\b\u00030w2\f\u0010R\u001a\b\u0012\u0004\u0012\u0002Ht0uH&J\u0010\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020{H&J7\u0010|\u001a\u00020y2\u0006\u0010}\u001a\u00020,2\u0006\u0010~\u001a\u00020\u007f2\u001d\b\u0002\u0010\u0080\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0082\u0001\u0012\u0004\u0012\u00020y0\u0081\u0001\u00a2\u0006\u0003\b\u0083\u0001H&J=\u0010|\u001a\u00020y2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020.0\u00042\u0006\u0010~\u001a\u00020\u007f2\u001d\b\u0002\u0010\u0080\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0082\u0001\u0012\u0004\u0012\u00020y0\u0081\u0001\u00a2\u0006\u0003\b\u0083\u0001H\u0016J9\u0010\u0084\u0001\u001a\u00020y2\u0007\u0010}\u001a\u00030\u0085\u00012%\u0010\u0086\u0001\u001a \u0012\u0015\u0012\u00130\u0001\u00a2\u0006\u000e\b\u0087\u0001\u0012\t\b\u0088\u0001\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020y0\u0081\u0001H&J8\u0010\u0084\u0001\u001a\u00020y2\u0006\u0010}\u001a\u00020,2%\u0010\u0086\u0001\u001a \u0012\u0015\u0012\u00130.\u00a2\u0006\u000e\b\u0087\u0001\u0012\t\b\u0088\u0001\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020y0\u0081\u0001H&J8\u0010\u0084\u0001\u001a\u00020y2\u0006\u0010}\u001a\u00020#2%\u0010\u0086\u0001\u001a \u0012\u0015\u0012\u00130%\u00a2\u0006\u000e\b\u0087\u0001\u0012\t\b\u0088\u0001\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020y0\u0081\u0001H&J8\u0010\u0084\u0001\u001a\u00020y2\u0006\u0010}\u001a\u00020&2%\u0010\u0086\u0001\u001a \u0012\u0015\u0012\u00130(\u00a2\u0006\u000e\b\u0087\u0001\u0012\t\b\u0088\u0001\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020y0\u0081\u0001H&R\u001a\u0010\u0002\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR>\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\rj\u0002`\u0011\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0004X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R>\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000f0\rj\u0002`\u0019\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0004X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R.\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\t0\u001d\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0004X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010/\u001a\u00020,\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u0010/\u001a\u00020,*\u000201X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u00102R*\u0010Y\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\rj\u0002`\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bZ\u0010[R*\u0010\\\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000f0\rj\u0002`\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b]\u0010[\u00a8\u0006\u008a\u0001"}, d2={"Lcom/feysh/corax/config/api/IOperatorFactory;", "", "subFields", "Lcom/feysh/corax/config/api/IWithSubFieldsT;", "Lcom/feysh/corax/config/api/ILocalT;", "getSubFields", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IWithSubFieldsT;", "attr", "Lcom/feysh/corax/config/api/IOperatorFactory$IAttributeGetSet;", "T", "getAttr", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IOperatorFactory$IAttributeGetSet;", "taint", "Lcom/feysh/corax/config/api/IAttribute;", "Lcom/feysh/corax/config/api/TaintProperty;", "", "Lcom/feysh/corax/config/api/ITaintType;", "Lcom/feysh/corax/config/api/ITaintSet;", "getTaint", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IAttribute;", "setTaint", "(Lcom/feysh/corax/config/api/ILocalT;Lcom/feysh/corax/config/api/IAttribute;)V", "via", "Lcom/feysh/corax/config/api/ViaProperty;", "Lcom/feysh/corax/config/api/IViaType;", "Lcom/feysh/corax/config/api/IViaSet;", "getVia", "setVia", "value", "Lcom/feysh/corax/config/api/ILocalValue;", "getValue", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/ILocalValue;", "setValue", "(Lcom/feysh/corax/config/api/ILocalT;Lcom/feysh/corax/config/api/ILocalValue;)V", "literal", "Lcom/feysh/corax/config/api/IStringExpr;", "string", "", "Lcom/feysh/corax/config/api/IIntExpr;", "int", "", "Lcom/feysh/corax/config/api/ILongExpr;", "long", "", "Lcom/feysh/corax/config/api/IBoolExpr;", "bool", "", "isConstant", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IBoolExpr;", "Lcom/feysh/corax/config/api/ITypedExpr;", "(Lcom/feysh/corax/config/api/ITypedExpr;)Lcom/feysh/corax/config/api/IBoolExpr;", "not", "or", "other", "and", "lt", "rhs", "le", "eq", "ge", "gt", "neq", "xor", "shl", "shr", "lshr", "plus", "minus", "getBoolean", "getString", "getInt", "getLong", "getEnumName", "isInstanceOf", "parentType", "toLowerCase", "startsWith", "str", "endsWith", "contains", "stringEquals", "taintOf", "type", "", "([Lcom/feysh/corax/config/api/ITaintType;)Lcom/feysh/corax/config/api/IAttribute;", "types", "", "viaOf", "([Lcom/feysh/corax/config/api/IViaType;)Lcom/feysh/corax/config/api/IAttribute;", "emptyTaint", "getEmptyTaint", "()Lcom/feysh/corax/config/api/IAttribute;", "emptyVia", "getEmptyVia", "anyOf", "Lkotlin/UnsafeVariance;", "local", "([Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/ILocalValue;", "null", "hasIntersection", "containsAll", "V", "Lcom/feysh/corax/config/api/IClassField;", "set", "single", "anyOr", "R", "T1", "T2", "second", "field", "Lcom/feysh/corax/config/api/IAccessPathT;", "declaringClass", "fieldName", "fieldType", "Lsoot/SootField;", "FieldType", "Lkotlin/reflect/KClass;", "F", "Lkotlin/reflect/KProperty;", "addStmt", "", "stmt", "Lcom/feysh/corax/config/api/IStmt;", "check", "expr", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "env", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/BugMessage$Env;", "Lkotlin/ExtensionFunctionType;", "eval", "Lcom/feysh/corax/config/api/IExpr;", "result", "Lkotlin/ParameterName;", "name", "IAttributeGetSet", "corax-config-api"})
public interface IOperatorFactory {
    @NotNull
    public IWithSubFieldsT getSubFields(@NotNull ILocalT<?> var1);

    @NotNull
    public <T> IAttributeGetSet getAttr(@NotNull ILocalT<T> var1);

    @NotNull
    public <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(@NotNull ILocalT<T> var1);

    public <T> void setTaint(@NotNull ILocalT<T> var1, @NotNull IAttribute<TaintProperty, Set<ITaintType>> var2);

    @NotNull
    public <T> IAttribute<ViaProperty, Set<IViaType>> getVia(@NotNull ILocalT<T> var1);

    public <T> void setVia(@NotNull ILocalT<T> var1, @NotNull IAttribute<ViaProperty, Set<IViaType>> var2);

    @NotNull
    public <T> ILocalValue<T> getValue(@NotNull ILocalT<T> var1);

    public <T> void setValue(@NotNull ILocalT<T> var1, @NotNull ILocalValue<T> var2);

    @NotNull
    public IStringExpr literal(@NotNull String var1);

    @NotNull
    public IIntExpr literal(int var1);

    @NotNull
    public ILongExpr literal(long var1);

    @NotNull
    public IBoolExpr literal(boolean var1);

    @NotNull
    public <T> IBoolExpr isConstant(@NotNull ILocalT<T> var1);

    @NotNull
    public IBoolExpr isConstant(@NotNull ITypedExpr var1);

    @NotNull
    public IBoolExpr not(@NotNull IBoolExpr var1);

    @NotNull
    public IBoolExpr or(@NotNull IBoolExpr var1, @NotNull IBoolExpr var2);

    @NotNull
    public IBoolExpr and(@NotNull IBoolExpr var1, @NotNull IBoolExpr var2);

    @NotNull
    public IBoolExpr lt(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    public IBoolExpr le(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    public IBoolExpr eq(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    public IBoolExpr ge(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    public IBoolExpr gt(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    public IBoolExpr neq(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    public IIntExpr and(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    public IIntExpr or(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    public IIntExpr xor(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    public IIntExpr shl(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    public IIntExpr shr(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    public IIntExpr lshr(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    public IIntExpr plus(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    public IIntExpr minus(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    public <T> IBoolExpr getBoolean(@NotNull ILocalT<T> var1);

    @NotNull
    public <T> IStringExpr getString(@NotNull ILocalT<T> var1);

    @NotNull
    public <T> IIntExpr getInt(@NotNull ILocalT<T> var1);

    @NotNull
    public <T> ILongExpr getLong(@NotNull ILocalT<T> var1);

    @NotNull
    public <T> IStringExpr getEnumName(@NotNull ILocalT<T> var1);

    @NotNull
    public <T> IBoolExpr isInstanceOf(@NotNull ILocalT<T> var1, @NotNull String var2);

    @NotNull
    public IStringExpr toLowerCase(@NotNull IStringExpr var1);

    @NotNull
    public IBoolExpr startsWith(@NotNull IStringExpr var1, @NotNull IStringExpr var2);

    @NotNull
    public IBoolExpr startsWith(@NotNull IStringExpr var1, @NotNull String var2);

    @NotNull
    public IBoolExpr endsWith(@NotNull IStringExpr var1, @NotNull IStringExpr var2);

    @NotNull
    public IBoolExpr endsWith(@NotNull IStringExpr var1, @NotNull String var2);

    @NotNull
    public IBoolExpr contains(@NotNull IStringExpr var1, @NotNull IStringExpr var2);

    @NotNull
    public IBoolExpr contains(@NotNull IStringExpr var1, @NotNull String var2);

    @NotNull
    public IBoolExpr stringEquals(@NotNull IStringExpr var1, @NotNull IStringExpr var2);

    @NotNull
    public IBoolExpr stringEquals(@NotNull IStringExpr var1, @NotNull String var2);

    @NotNull
    public IAttribute<TaintProperty, Set<ITaintType>> taintOf(ITaintType ... var1);

    @NotNull
    public IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull Collection<? extends ITaintType> var1);

    @NotNull
    public IAttribute<ViaProperty, Set<IViaType>> viaOf(IViaType ... var1);

    @NotNull
    public IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint();

    @NotNull
    public IAttribute<ViaProperty, Set<IViaType>> getEmptyVia();

    @NotNull
    public <T> ILocalValue<T> anyOf(ILocalT<T> ... var1);

    @NotNull
    public <T> ILocalValue<T> null();

    @NotNull
    public IBoolExpr hasIntersection(@NotNull IAttribute<TaintProperty, Set<ITaintType>> var1, @NotNull IAttribute<TaintProperty, Set<ITaintType>> var2);

    @NotNull
    public IBoolExpr contains(@NotNull IAttribute<TaintProperty, Set<ITaintType>> var1, @NotNull ITaintType var2);

    @NotNull
    public IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> var1, @NotNull ITaintType var2);

    @NotNull
    public IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> var1, @NotNull IAttribute<TaintProperty, Set<ITaintType>> var2);

    @NotNull
    public <T extends IClassField, V extends Set<? extends Object>> IAttribute<T, V> plus(@NotNull IAttribute<T, V> var1, @NotNull IAttribute<T, V> var2);

    @NotNull
    public <T extends IClassField, V extends Set<? extends Object>> IAttribute<T, V> minus(@NotNull IAttribute<T, V> var1, @NotNull IAttribute<T, V> var2);

    @NotNull
    public IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> var1, @NotNull ITaintType var2);

    @NotNull
    public IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> var1, @NotNull ITaintType var2);

    @NotNull
    public IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IAttribute<ViaProperty, Set<IViaType>> var1, @NotNull IViaType var2);

    @NotNull
    public IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IAttribute<ViaProperty, Set<IViaType>> var1, @NotNull IViaType var2);

    @NotNull
    public <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull ILocalValue<T1> var1, @NotNull ILocalValue<T2> var2);

    @NotNull
    public <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull ILocalT<T1> var1, @NotNull ILocalT<T2> var2);

    @NotNull
    public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> var1, @Nullable String var2, @NotNull String var3, @Nullable String var4);

    @NotNull
    public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> var1, @NotNull SootField var2);

    @NotNull
    public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> var1, @Nullable String var2, @NotNull String var3, @NotNull KClass<FieldType> var4);

    @NotNull
    public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> var1, @Nullable KClass<?> var2, @NotNull String var3, @NotNull KClass<FieldType> var4);

    @NotNull
    public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> var1, @NotNull KClass<?> var2, @NotNull String var3, @Nullable String var4);

    @NotNull
    public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> var1, @NotNull IClassField var2);

    @NotNull
    public <T, F> IAccessPathT<F> field(@NotNull ILocalT<T> var1, @NotNull KProperty<? extends F> var2);

    @NotNull
    public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> var1, @NotNull KProperty<?> var2, @NotNull KClass<FieldType> var3);

    public void addStmt(@NotNull IStmt var1);

    public void check(@NotNull IBoolExpr var1, @NotNull CheckType var2, @NotNull Function1<? super BugMessage.Env, Unit> var3);

    public void check(@NotNull ILocalT<Boolean> var1, @NotNull CheckType var2, @NotNull Function1<? super BugMessage.Env, Unit> var3);

    public void eval(@NotNull IExpr var1, @NotNull Function1<Object, Unit> var2);

    public void eval(@NotNull IBoolExpr var1, @NotNull Function1<? super Boolean, Unit> var2);

    public void eval(@NotNull IStringExpr var1, @NotNull Function1<? super String, Unit> var2);

    public void eval(@NotNull IIntExpr var1, @NotNull Function1<? super Integer, Unit> var2);

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @NotNull
        public static IBoolExpr startsWith(@NotNull IOperatorFactory $this, @NotNull IStringExpr $receiver, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return $this.startsWith($receiver, $this.literal(str));
        }

        @NotNull
        public static IBoolExpr endsWith(@NotNull IOperatorFactory $this, @NotNull IStringExpr $receiver, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return $this.endsWith($receiver, $this.literal(str));
        }

        @NotNull
        public static IBoolExpr contains(@NotNull IOperatorFactory $this, @NotNull IStringExpr $receiver, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return $this.contains($receiver, $this.literal(str));
        }

        @NotNull
        public static IBoolExpr stringEquals(@NotNull IOperatorFactory $this, @NotNull IStringExpr $receiver, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return $this.stringEquals($receiver, $this.literal(str));
        }

        @NotNull
        public static IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull IOperatorFactory $this, ITaintType ... type) {
            Intrinsics.checkNotNullParameter((Object)type, (String)"type");
            return $this.taintOf(ArraysKt.asList((Object[])type));
        }

        @NotNull
        public static IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint(@NotNull IOperatorFactory $this) {
            return $this.taintOf(new ITaintType[0]);
        }

        @NotNull
        public static IAttribute<ViaProperty, Set<IViaType>> getEmptyVia(@NotNull IOperatorFactory $this) {
            return $this.viaOf(new IViaType[0]);
        }

        @NotNull
        public static IBoolExpr containsAll(@NotNull IOperatorFactory $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType taint) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
            ITaintType[] iTaintTypeArray = new ITaintType[]{taint};
            return $this.containsAll($receiver, $this.taintOf(iTaintTypeArray));
        }

        @NotNull
        public static IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IOperatorFactory $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            ITaintType[] iTaintTypeArray = new ITaintType[]{single};
            return $this.plus($receiver, $this.taintOf(iTaintTypeArray));
        }

        @NotNull
        public static IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IOperatorFactory $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            ITaintType[] iTaintTypeArray = new ITaintType[]{single};
            return $this.minus($receiver, $this.taintOf(iTaintTypeArray));
        }

        @NotNull
        public static IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IOperatorFactory $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            IViaType[] iViaTypeArray = new IViaType[]{single};
            return $this.plus($receiver, $this.viaOf(iViaTypeArray));
        }

        @NotNull
        public static IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IOperatorFactory $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            IViaType[] iViaTypeArray = new IViaType[]{single};
            return $this.minus($receiver, $this.viaOf(iViaTypeArray));
        }

        @NotNull
        public static <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull IOperatorFactory $this, @NotNull ILocalT<T1> $receiver, @NotNull ILocalT<T2> second) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter(second, (String)"second");
            return $this.anyOr($this.getValue($receiver), $this.getValue(second));
        }

        public static /* synthetic */ IAccessPathT field$default(IOperatorFactory iOperatorFactory, ILocalT iLocalT, String string, String string2, String string3, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: field");
            }
            if ((n & 4) != 0) {
                string3 = null;
            }
            return iOperatorFactory.field(iLocalT, string, string2, string3);
        }

        @NotNull
        public static <T> IAccessPathT<Object> field(@NotNull IOperatorFactory $this, @NotNull ILocalT<T> $receiver, @NotNull SootField field) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)field, (String)"field");
            String string = field.getDeclaringClass().getName();
            String string2 = field.getName();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getName(...)");
            Type type = field.getType();
            Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
            return $this.field($receiver, string, string2, UtilsKt.getTypename(type));
        }

        @NotNull
        public static <T, FieldType> IAccessPathT<FieldType> field(@NotNull IOperatorFactory $this, @NotNull ILocalT<T> $receiver, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            Intrinsics.checkNotNullParameter(type, (String)"type");
            KClass<?> kClass = declaringClass;
            return $this.field($receiver, kClass != null ? UtilsKt.getSootTypeName(kClass) : null, fieldName, type);
        }

        @NotNull
        public static <T> IAccessPathT<Object> field(@NotNull IOperatorFactory $this, @NotNull ILocalT<T> $receiver, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            return $this.field($receiver, UtilsKt.getSootTypeName(declaringClass), fieldName, fieldType);
        }

        public static /* synthetic */ IAccessPathT field$default(IOperatorFactory iOperatorFactory, ILocalT iLocalT, KClass kClass, String string, String string2, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: field");
            }
            if ((n & 4) != 0) {
                string2 = null;
            }
            return iOperatorFactory.field(iLocalT, kClass, string, string2);
        }

        public static /* synthetic */ void check$default(IOperatorFactory iOperatorFactory, IBoolExpr iBoolExpr, CheckType checkType, Function1 function1, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: check");
            }
            if ((n & 4) != 0) {
                function1 = DefaultImpls::check$lambda$0;
            }
            iOperatorFactory.check(iBoolExpr, checkType, (Function1<? super BugMessage.Env, Unit>)function1);
        }

        public static void check(@NotNull IOperatorFactory $this, @NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
            Intrinsics.checkNotNullParameter(expr, (String)"expr");
            Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
            Intrinsics.checkNotNullParameter(env, (String)"env");
            $this.check($this.getBoolean(expr), checkType, env);
        }

        public static /* synthetic */ void check$default(IOperatorFactory iOperatorFactory, ILocalT iLocalT, CheckType checkType, Function1 function1, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: check");
            }
            if ((n & 4) != 0) {
                function1 = DefaultImpls::check$lambda$1;
            }
            iOperatorFactory.check(iLocalT, checkType, (Function1<? super BugMessage.Env, Unit>)function1);
        }

        private static Unit check$lambda$0(BugMessage.Env env) {
            Intrinsics.checkNotNullParameter((Object)env, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit check$lambda$1(BugMessage.Env env) {
            Intrinsics.checkNotNullParameter((Object)env, (String)"<this>");
            return Unit.INSTANCE;
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\n\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H\u00a6\u0002J+\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00040\nH\u00a6\u0002J\u001f\u0010\u0007\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\t\u001a\u00020\u000bH\u00a6\u0002J\u001f\u0010\u0007\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\t\u001a\u00020\fH\u00a6\u0002J\u001f\u0010\u0007\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\t\u001a\u00020\rH\u00a6\u0002J\u001f\u0010\u0007\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\t\u001a\u00020\u000eH\u00a6\u0002J\u001f\u0010\u0007\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\t\u001a\u00020\u000fH\u00a6\u0002J%\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\u0006\u0010\t\u001a\u00020\u0010H\u00a6\u0002\u00a8\u0006\u0011"}, d2={"Lcom/feysh/corax/config/api/IOperatorFactory$IAttributeGetSet;", "", "get", "Lcom/feysh/corax/config/api/IAccessPathT;", "T", "id", "Lcom/feysh/corax/config/api/CustomAttributeID;", "set", "", "value", "Lcom/feysh/corax/config/api/ILocalValue;", "", "", "", "", "", "Lcom/feysh/corax/config/api/ITypedExpr;", "corax-config-api"})
    public static interface IAttributeGetSet {
        @NotNull
        public <T> IAccessPathT<T> get(@NotNull CustomAttributeID<T> var1);

        public <T> void set(@NotNull CustomAttributeID<T> var1, @NotNull ILocalValue<T> var2);

        public void set(@NotNull CustomAttributeID<Boolean> var1, boolean var2);

        public void set(@NotNull CustomAttributeID<Short> var1, short var2);

        public void set(@NotNull CustomAttributeID<Integer> var1, int var2);

        public void set(@NotNull CustomAttributeID<Long> var1, long var2);

        public void set(@NotNull CustomAttributeID<String> var1, @NotNull String var2);

        public <T> void set(@NotNull CustomAttributeID<T> var1, @NotNull ITypedExpr var2);
    }
}

