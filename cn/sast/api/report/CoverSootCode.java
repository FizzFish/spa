/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.CoverData
 *  cn.sast.api.report.CoverSootCode
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.Unit
 */
package cn.sast.api.report;

import cn.sast.api.report.CoverData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0001\u0002\u0018\u0019\u00a8\u0006\u001a"}, d2={"Lcn/sast/api/report/CoverSootCode;", "Lcn/sast/api/report/CoverData;", "method", "Lsoot/SootMethod;", "unit", "Lsoot/Unit;", "<init>", "(Lsoot/SootMethod;Lsoot/Unit;)V", "getMethod", "()Lsoot/SootMethod;", "getUnit", "()Lsoot/Unit;", "clazz", "Lsoot/SootClass;", "getClazz", "()Lsoot/SootClass;", "className", "", "getClassName", "()Ljava/lang/String;", "lineNumber", "", "getLineNumber", "()I", "Lcn/sast/api/report/CoverInst;", "Lcn/sast/api/report/CoverTaint;", "corax-api"})
public abstract class CoverSootCode
extends CoverData {
    @NotNull
    private final SootMethod method;
    @NotNull
    private final Unit unit;

    private CoverSootCode(SootMethod method, Unit unit) {
        super(null);
        this.method = method;
        this.unit = unit;
    }

    @NotNull
    public SootMethod getMethod() {
        return this.method;
    }

    @NotNull
    public Unit getUnit() {
        return this.unit;
    }

    @NotNull
    public final SootClass getClazz() {
        SootClass sootClass = this.getMethod().getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
        return sootClass;
    }

    @NotNull
    public final String getClassName() {
        String string = this.getClazz().getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
        return string;
    }

    public final int getLineNumber() {
        return this.getUnit().getJavaSourceStartLineNumber();
    }

    public /* synthetic */ CoverSootCode(SootMethod method, Unit unit, DefaultConstructorMarker $constructor_marker) {
        this(method, unit);
    }
}

