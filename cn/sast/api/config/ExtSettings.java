/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ExtSettings
 *  cn.sast.api.config.ExtSettings$dataFlowCacheMaximumSizeFactor$2
 *  cn.sast.api.config.ExtSettings$dataFlowCacheMaximumSizeFactor$3
 *  cn.sast.api.config.ExtSettingsKt
 *  kotlin.Metadata
 *  kotlin.Triple
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.properties.ReadWriteProperty
 *  kotlin.reflect.KProperty
 *  org.jetbrains.annotations.NotNull
 *  org.utbot.common.AbstractSettings
 */
package cn.sast.api.config;

import cn.sast.api.config.ExtSettings;
import cn.sast.api.config.ExtSettingsKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.utbot.common.AbstractSettings;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\bA\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0006\u001a\u00020\u0005H\u0007R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR+\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR+\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\rR+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u001c8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R+\u0010#\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u001c8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b&\u0010\u000f\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R+\u0010(\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020'8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b-\u0010\u000f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R+\u0010.\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b1\u0010\u000f\u001a\u0004\b/\u0010\u000b\"\u0004\b0\u0010\rR+\u00102\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u001c8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b5\u0010\u000f\u001a\u0004\b3\u0010\u001f\"\u0004\b4\u0010!R+\u00106\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b9\u0010\u000f\u001a\u0004\b7\u0010\u000b\"\u0004\b8\u0010\rR+\u0010:\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u001c8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b=\u0010\u000f\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!R+\u0010?\u001a\u00020>2\u0006\u0010\u0007\u001a\u00020>8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bD\u0010\u000f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR+\u0010E\u001a\u00020>2\u0006\u0010\u0007\u001a\u00020>8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bH\u0010\u000f\u001a\u0004\bF\u0010A\"\u0004\bG\u0010CR+\u0010I\u001a\u00020>2\u0006\u0010\u0007\u001a\u00020>8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bL\u0010\u000f\u001a\u0004\bJ\u0010A\"\u0004\bK\u0010CR+\u0010M\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bP\u0010\u000f\u001a\u0004\bN\u0010\u000b\"\u0004\bO\u0010\rR+\u0010Q\u001a\u00020>2\u0006\u0010\u0007\u001a\u00020>8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bT\u0010\u000f\u001a\u0004\bR\u0010A\"\u0004\bS\u0010CR+\u0010U\u001a\u00020>2\u0006\u0010\u0007\u001a\u00020>8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bX\u0010\u000f\u001a\u0004\bV\u0010A\"\u0004\bW\u0010CR+\u0010Y\u001a\u00020>2\u0006\u0010\u0007\u001a\u00020>8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\\\u0010\u000f\u001a\u0004\bZ\u0010A\"\u0004\b[\u0010CR+\u0010]\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bb\u0010\u000f\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR+\u0010c\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bf\u0010\u000f\u001a\u0004\bd\u0010\u000b\"\u0004\be\u0010\rR+\u0010g\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bj\u0010\u000f\u001a\u0004\bh\u0010\u000b\"\u0004\bi\u0010\rR+\u0010k\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bn\u0010\u000f\u001a\u0004\bl\u0010\u000b\"\u0004\bm\u0010\rR+\u0010o\u001a\u00020>2\u0006\u0010\u0007\u001a\u00020>8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\br\u0010\u000f\u001a\u0004\bp\u0010A\"\u0004\bq\u0010CR+\u0010s\u001a\u00020>2\u0006\u0010\u0007\u001a\u00020>8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bv\u0010\u000f\u001a\u0004\bt\u0010A\"\u0004\bu\u0010CR+\u0010w\u001a\u00020>2\u0006\u0010\u0007\u001a\u00020>8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bz\u0010\u000f\u001a\u0004\bx\u0010A\"\u0004\by\u0010CR+\u0010{\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b~\u0010\u000f\u001a\u0004\b|\u0010\u000b\"\u0004\b}\u0010\r\u00a8\u0006\u007f"}, d2={"Lcn/sast/api/config/ExtSettings;", "Lorg/utbot/common/AbstractSettings;", "<init>", "()V", "defaultSettingsPath", "", "getPath", "<set-?>", "", "dataFlowIteratorCountForAppClasses", "getDataFlowIteratorCountForAppClasses", "()I", "setDataFlowIteratorCountForAppClasses", "(I)V", "dataFlowIteratorCountForAppClasses$delegate", "Lkotlin/properties/ReadWriteProperty;", "dataFlowIteratorCountForLibClasses", "getDataFlowIteratorCountForLibClasses", "setDataFlowIteratorCountForLibClasses", "dataFlowIteratorCountForLibClasses$delegate", "dataFlowIteratorIsFixPointSizeLimit", "getDataFlowIteratorIsFixPointSizeLimit", "setDataFlowIteratorIsFixPointSizeLimit", "dataFlowIteratorIsFixPointSizeLimit$delegate", "dataFlowMethodUnitsSizeLimit", "getDataFlowMethodUnitsSizeLimit", "setDataFlowMethodUnitsSizeLimit", "dataFlowMethodUnitsSizeLimit$delegate", "", "dataFlowCacheExpireAfterAccess", "getDataFlowCacheExpireAfterAccess", "()J", "setDataFlowCacheExpireAfterAccess", "(J)V", "dataFlowCacheExpireAfterAccess$delegate", "dataFlowCacheMaximumWeight", "getDataFlowCacheMaximumWeight", "setDataFlowCacheMaximumWeight", "dataFlowCacheMaximumWeight$delegate", "", "dataFlowCacheMaximumSizeFactor", "getDataFlowCacheMaximumSizeFactor", "()D", "setDataFlowCacheMaximumSizeFactor", "(D)V", "dataFlowCacheMaximumSizeFactor$delegate", "calleeDepChainMaxNumForLibClassesInInterProceduraldataFlow", "getCalleeDepChainMaxNumForLibClassesInInterProceduraldataFlow", "setCalleeDepChainMaxNumForLibClassesInInterProceduraldataFlow", "calleeDepChainMaxNumForLibClassesInInterProceduraldataFlow$delegate", "dataFlowInterProceduralCalleeDepChainMaxNum", "getDataFlowInterProceduralCalleeDepChainMaxNum", "setDataFlowInterProceduralCalleeDepChainMaxNum", "dataFlowInterProceduralCalleeDepChainMaxNum$delegate", "dataFlowInterProceduralCalleeTimeOut", "getDataFlowInterProceduralCalleeTimeOut", "setDataFlowInterProceduralCalleeTimeOut", "dataFlowInterProceduralCalleeTimeOut$delegate", "dataFlowResolveTargetsMaxNum", "getDataFlowResolveTargetsMaxNum", "setDataFlowResolveTargetsMaxNum", "dataFlowResolveTargetsMaxNum$delegate", "", "dataFlowResultPathOnlyStmt", "getDataFlowResultPathOnlyStmt", "()Z", "setDataFlowResultPathOnlyStmt", "(Z)V", "dataFlowResultPathOnlyStmt$delegate", "enableProcessBar", "getEnableProcessBar", "setEnableProcessBar", "enableProcessBar$delegate", "showMetadata", "getShowMetadata", "setShowMetadata", "showMetadata$delegate", "tabSize", "getTabSize", "setTabSize", "tabSize$delegate", "dumpCompleteDotCg", "getDumpCompleteDotCg", "setDumpCompleteDotCg", "dumpCompleteDotCg$delegate", "prettyPrintJsonReport", "getPrettyPrintJsonReport", "setPrettyPrintJsonReport", "prettyPrintJsonReport$delegate", "prettyPrintPlistReport", "getPrettyPrintPlistReport", "setPrettyPrintPlistReport", "prettyPrintPlistReport$delegate", "sqliteJournalMode", "getSqliteJournalMode", "()Ljava/lang/String;", "setSqliteJournalMode", "(Ljava/lang/String;)V", "sqliteJournalMode$delegate", "jdCoreDecompileTimeOut", "getJdCoreDecompileTimeOut", "setJdCoreDecompileTimeOut", "jdCoreDecompileTimeOut$delegate", "skip_large_class_by_maximum_methods", "getSkip_large_class_by_maximum_methods", "setSkip_large_class_by_maximum_methods", "skip_large_class_by_maximum_methods$delegate", "skip_large_class_by_maximum_fields", "getSkip_large_class_by_maximum_fields", "setSkip_large_class_by_maximum_fields", "skip_large_class_by_maximum_fields$delegate", "castNeverFailsOfPhantomClass", "getCastNeverFailsOfPhantomClass", "setCastNeverFailsOfPhantomClass", "castNeverFailsOfPhantomClass$delegate", "printAliasInfo", "getPrintAliasInfo", "setPrintAliasInfo", "printAliasInfo$delegate", "UseRoaringPointsToSet", "getUseRoaringPointsToSet", "setUseRoaringPointsToSet", "UseRoaringPointsToSet$delegate", "hashVersion", "getHashVersion", "setHashVersion", "hashVersion$delegate", "corax-api"})
public final class ExtSettings
extends AbstractSettings {
    @NotNull
    public static final ExtSettings INSTANCE;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private static final ReadWriteProperty dataFlowIteratorCountForAppClasses$delegate;
    @NotNull
    private static final ReadWriteProperty dataFlowIteratorCountForLibClasses$delegate;
    @NotNull
    private static final ReadWriteProperty dataFlowIteratorIsFixPointSizeLimit$delegate;
    @NotNull
    private static final ReadWriteProperty dataFlowMethodUnitsSizeLimit$delegate;
    @NotNull
    private static final ReadWriteProperty dataFlowCacheExpireAfterAccess$delegate;
    @NotNull
    private static final ReadWriteProperty dataFlowCacheMaximumWeight$delegate;
    @NotNull
    private static final ReadWriteProperty dataFlowCacheMaximumSizeFactor$delegate;
    @NotNull
    private static final ReadWriteProperty calleeDepChainMaxNumForLibClassesInInterProceduraldataFlow$delegate;
    @NotNull
    private static final ReadWriteProperty dataFlowInterProceduralCalleeDepChainMaxNum$delegate;
    @NotNull
    private static final ReadWriteProperty dataFlowInterProceduralCalleeTimeOut$delegate;
    @NotNull
    private static final ReadWriteProperty dataFlowResolveTargetsMaxNum$delegate;
    @NotNull
    private static final ReadWriteProperty dataFlowResultPathOnlyStmt$delegate;
    @NotNull
    private static final ReadWriteProperty enableProcessBar$delegate;
    @NotNull
    private static final ReadWriteProperty showMetadata$delegate;
    @NotNull
    private static final ReadWriteProperty tabSize$delegate;
    @NotNull
    private static final ReadWriteProperty dumpCompleteDotCg$delegate;
    @NotNull
    private static final ReadWriteProperty prettyPrintJsonReport$delegate;
    @NotNull
    private static final ReadWriteProperty prettyPrintPlistReport$delegate;
    @NotNull
    private static final ReadWriteProperty sqliteJournalMode$delegate;
    @NotNull
    private static final ReadWriteProperty jdCoreDecompileTimeOut$delegate;
    @NotNull
    private static final ReadWriteProperty skip_large_class_by_maximum_methods$delegate;
    @NotNull
    private static final ReadWriteProperty skip_large_class_by_maximum_fields$delegate;
    @NotNull
    private static final ReadWriteProperty castNeverFailsOfPhantomClass$delegate;
    @NotNull
    private static final ReadWriteProperty printAliasInfo$delegate;
    @NotNull
    private static final ReadWriteProperty UseRoaringPointsToSet$delegate;
    @NotNull
    private static final ReadWriteProperty hashVersion$delegate;

    private ExtSettings() {
        super(ExtSettingsKt.access$getLogger$p(), "corax.settings.path", ExtSettingsKt.access$getDefaultSettingsPath$p());
    }

    @NotNull
    public final String defaultSettingsPath() {
        return ExtSettingsKt.access$getDefaultSettingsPath$p();
    }

    @JvmStatic
    @NotNull
    public static final String getPath() {
        String string = System.getProperty("corax.settings.path");
        if (string == null) {
            string = ExtSettingsKt.access$getDefaultSettingsPath$p();
        }
        return string;
    }

    public final int getDataFlowIteratorCountForAppClasses() {
        return ((Number)dataFlowIteratorCountForAppClasses$delegate.getValue((Object)this, $$delegatedProperties[0])).intValue();
    }

    public final void setDataFlowIteratorCountForAppClasses(int n) {
        dataFlowIteratorCountForAppClasses$delegate.setValue((Object)this, $$delegatedProperties[0], (Object)n);
    }

    public final int getDataFlowIteratorCountForLibClasses() {
        return ((Number)dataFlowIteratorCountForLibClasses$delegate.getValue((Object)this, $$delegatedProperties[1])).intValue();
    }

    public final void setDataFlowIteratorCountForLibClasses(int n) {
        dataFlowIteratorCountForLibClasses$delegate.setValue((Object)this, $$delegatedProperties[1], (Object)n);
    }

    public final int getDataFlowIteratorIsFixPointSizeLimit() {
        return ((Number)dataFlowIteratorIsFixPointSizeLimit$delegate.getValue((Object)this, $$delegatedProperties[2])).intValue();
    }

    public final void setDataFlowIteratorIsFixPointSizeLimit(int n) {
        dataFlowIteratorIsFixPointSizeLimit$delegate.setValue((Object)this, $$delegatedProperties[2], (Object)n);
    }

    public final int getDataFlowMethodUnitsSizeLimit() {
        return ((Number)dataFlowMethodUnitsSizeLimit$delegate.getValue((Object)this, $$delegatedProperties[3])).intValue();
    }

    public final void setDataFlowMethodUnitsSizeLimit(int n) {
        dataFlowMethodUnitsSizeLimit$delegate.setValue((Object)this, $$delegatedProperties[3], (Object)n);
    }

    public final long getDataFlowCacheExpireAfterAccess() {
        return ((Number)dataFlowCacheExpireAfterAccess$delegate.getValue((Object)this, $$delegatedProperties[4])).longValue();
    }

    public final void setDataFlowCacheExpireAfterAccess(long l) {
        dataFlowCacheExpireAfterAccess$delegate.setValue((Object)this, $$delegatedProperties[4], (Object)l);
    }

    public final long getDataFlowCacheMaximumWeight() {
        return ((Number)dataFlowCacheMaximumWeight$delegate.getValue((Object)this, $$delegatedProperties[5])).longValue();
    }

    public final void setDataFlowCacheMaximumWeight(long l) {
        dataFlowCacheMaximumWeight$delegate.setValue((Object)this, $$delegatedProperties[5], (Object)l);
    }

    public final double getDataFlowCacheMaximumSizeFactor() {
        return ((Number)dataFlowCacheMaximumSizeFactor$delegate.getValue((Object)this, $$delegatedProperties[6])).doubleValue();
    }

    public final void setDataFlowCacheMaximumSizeFactor(double d) {
        dataFlowCacheMaximumSizeFactor$delegate.setValue((Object)this, $$delegatedProperties[6], (Object)d);
    }

    public final int getCalleeDepChainMaxNumForLibClassesInInterProceduraldataFlow() {
        return ((Number)calleeDepChainMaxNumForLibClassesInInterProceduraldataFlow$delegate.getValue((Object)this, $$delegatedProperties[7])).intValue();
    }

    public final void setCalleeDepChainMaxNumForLibClassesInInterProceduraldataFlow(int n) {
        calleeDepChainMaxNumForLibClassesInInterProceduraldataFlow$delegate.setValue((Object)this, $$delegatedProperties[7], (Object)n);
    }

    public final long getDataFlowInterProceduralCalleeDepChainMaxNum() {
        return ((Number)dataFlowInterProceduralCalleeDepChainMaxNum$delegate.getValue((Object)this, $$delegatedProperties[8])).longValue();
    }

    public final void setDataFlowInterProceduralCalleeDepChainMaxNum(long l) {
        dataFlowInterProceduralCalleeDepChainMaxNum$delegate.setValue((Object)this, $$delegatedProperties[8], (Object)l);
    }

    public final int getDataFlowInterProceduralCalleeTimeOut() {
        return ((Number)dataFlowInterProceduralCalleeTimeOut$delegate.getValue((Object)this, $$delegatedProperties[9])).intValue();
    }

    public final void setDataFlowInterProceduralCalleeTimeOut(int n) {
        dataFlowInterProceduralCalleeTimeOut$delegate.setValue((Object)this, $$delegatedProperties[9], (Object)n);
    }

    public final long getDataFlowResolveTargetsMaxNum() {
        return ((Number)dataFlowResolveTargetsMaxNum$delegate.getValue((Object)this, $$delegatedProperties[10])).longValue();
    }

    public final void setDataFlowResolveTargetsMaxNum(long l) {
        dataFlowResolveTargetsMaxNum$delegate.setValue((Object)this, $$delegatedProperties[10], (Object)l);
    }

    public final boolean getDataFlowResultPathOnlyStmt() {
        return (Boolean)dataFlowResultPathOnlyStmt$delegate.getValue((Object)this, $$delegatedProperties[11]);
    }

    public final void setDataFlowResultPathOnlyStmt(boolean bl) {
        dataFlowResultPathOnlyStmt$delegate.setValue((Object)this, $$delegatedProperties[11], (Object)bl);
    }

    public final boolean getEnableProcessBar() {
        return (Boolean)enableProcessBar$delegate.getValue((Object)this, $$delegatedProperties[12]);
    }

    public final void setEnableProcessBar(boolean bl) {
        enableProcessBar$delegate.setValue((Object)this, $$delegatedProperties[12], (Object)bl);
    }

    public final boolean getShowMetadata() {
        return (Boolean)showMetadata$delegate.getValue((Object)this, $$delegatedProperties[13]);
    }

    public final void setShowMetadata(boolean bl) {
        showMetadata$delegate.setValue((Object)this, $$delegatedProperties[13], (Object)bl);
    }

    public final int getTabSize() {
        return ((Number)tabSize$delegate.getValue((Object)this, $$delegatedProperties[14])).intValue();
    }

    public final void setTabSize(int n) {
        tabSize$delegate.setValue((Object)this, $$delegatedProperties[14], (Object)n);
    }

    public final boolean getDumpCompleteDotCg() {
        return (Boolean)dumpCompleteDotCg$delegate.getValue((Object)this, $$delegatedProperties[15]);
    }

    public final void setDumpCompleteDotCg(boolean bl) {
        dumpCompleteDotCg$delegate.setValue((Object)this, $$delegatedProperties[15], (Object)bl);
    }

    public final boolean getPrettyPrintJsonReport() {
        return (Boolean)prettyPrintJsonReport$delegate.getValue((Object)this, $$delegatedProperties[16]);
    }

    public final void setPrettyPrintJsonReport(boolean bl) {
        prettyPrintJsonReport$delegate.setValue((Object)this, $$delegatedProperties[16], (Object)bl);
    }

    public final boolean getPrettyPrintPlistReport() {
        return (Boolean)prettyPrintPlistReport$delegate.getValue((Object)this, $$delegatedProperties[17]);
    }

    public final void setPrettyPrintPlistReport(boolean bl) {
        prettyPrintPlistReport$delegate.setValue((Object)this, $$delegatedProperties[17], (Object)bl);
    }

    @NotNull
    public final String getSqliteJournalMode() {
        return (String)sqliteJournalMode$delegate.getValue((Object)this, $$delegatedProperties[18]);
    }

    public final void setSqliteJournalMode(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        sqliteJournalMode$delegate.setValue((Object)this, $$delegatedProperties[18], (Object)string);
    }

    public final int getJdCoreDecompileTimeOut() {
        return ((Number)jdCoreDecompileTimeOut$delegate.getValue((Object)this, $$delegatedProperties[19])).intValue();
    }

    public final void setJdCoreDecompileTimeOut(int n) {
        jdCoreDecompileTimeOut$delegate.setValue((Object)this, $$delegatedProperties[19], (Object)n);
    }

    public final int getSkip_large_class_by_maximum_methods() {
        return ((Number)skip_large_class_by_maximum_methods$delegate.getValue((Object)this, $$delegatedProperties[20])).intValue();
    }

    public final void setSkip_large_class_by_maximum_methods(int n) {
        skip_large_class_by_maximum_methods$delegate.setValue((Object)this, $$delegatedProperties[20], (Object)n);
    }

    public final int getSkip_large_class_by_maximum_fields() {
        return ((Number)skip_large_class_by_maximum_fields$delegate.getValue((Object)this, $$delegatedProperties[21])).intValue();
    }

    public final void setSkip_large_class_by_maximum_fields(int n) {
        skip_large_class_by_maximum_fields$delegate.setValue((Object)this, $$delegatedProperties[21], (Object)n);
    }

    public final boolean getCastNeverFailsOfPhantomClass() {
        return (Boolean)castNeverFailsOfPhantomClass$delegate.getValue((Object)this, $$delegatedProperties[22]);
    }

    public final void setCastNeverFailsOfPhantomClass(boolean bl) {
        castNeverFailsOfPhantomClass$delegate.setValue((Object)this, $$delegatedProperties[22], (Object)bl);
    }

    public final boolean getPrintAliasInfo() {
        return (Boolean)printAliasInfo$delegate.getValue((Object)this, $$delegatedProperties[23]);
    }

    public final void setPrintAliasInfo(boolean bl) {
        printAliasInfo$delegate.setValue((Object)this, $$delegatedProperties[23], (Object)bl);
    }

    public final boolean getUseRoaringPointsToSet() {
        return (Boolean)UseRoaringPointsToSet$delegate.getValue((Object)this, $$delegatedProperties[24]);
    }

    public final void setUseRoaringPointsToSet(boolean bl) {
        UseRoaringPointsToSet$delegate.setValue((Object)this, $$delegatedProperties[24], (Object)bl);
    }

    public final int getHashVersion() {
        return ((Number)hashVersion$delegate.getValue((Object)this, $$delegatedProperties[25])).intValue();
    }

    public final void setHashVersion(int n) {
        hashVersion$delegate.setValue((Object)this, $$delegatedProperties[25], (Object)n);
    }

    private static final Object _init_$lambda$0() {
        return "ExtSettingsPath: " + ExtSettings.getPath();
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "dataFlowIteratorCountForAppClasses", "getDataFlowIteratorCountForAppClasses()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "dataFlowIteratorCountForLibClasses", "getDataFlowIteratorCountForLibClasses()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "dataFlowIteratorIsFixPointSizeLimit", "getDataFlowIteratorIsFixPointSizeLimit()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "dataFlowMethodUnitsSizeLimit", "getDataFlowMethodUnitsSizeLimit()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "dataFlowCacheExpireAfterAccess", "getDataFlowCacheExpireAfterAccess()J", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "dataFlowCacheMaximumWeight", "getDataFlowCacheMaximumWeight()J", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "dataFlowCacheMaximumSizeFactor", "getDataFlowCacheMaximumSizeFactor()D", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "calleeDepChainMaxNumForLibClassesInInterProceduraldataFlow", "getCalleeDepChainMaxNumForLibClassesInInterProceduraldataFlow()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "dataFlowInterProceduralCalleeDepChainMaxNum", "getDataFlowInterProceduralCalleeDepChainMaxNum()J", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "dataFlowInterProceduralCalleeTimeOut", "getDataFlowInterProceduralCalleeTimeOut()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "dataFlowResolveTargetsMaxNum", "getDataFlowResolveTargetsMaxNum()J", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "dataFlowResultPathOnlyStmt", "getDataFlowResultPathOnlyStmt()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "enableProcessBar", "getEnableProcessBar()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "showMetadata", "getShowMetadata()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "tabSize", "getTabSize()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "dumpCompleteDotCg", "getDumpCompleteDotCg()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "prettyPrintJsonReport", "getPrettyPrintJsonReport()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "prettyPrintPlistReport", "getPrettyPrintPlistReport()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "sqliteJournalMode", "getSqliteJournalMode()Ljava/lang/String;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "jdCoreDecompileTimeOut", "getJdCoreDecompileTimeOut()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "skip_large_class_by_maximum_methods", "getSkip_large_class_by_maximum_methods()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "skip_large_class_by_maximum_fields", "getSkip_large_class_by_maximum_fields()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "castNeverFailsOfPhantomClass", "getCastNeverFailsOfPhantomClass()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "printAliasInfo", "getPrintAliasInfo()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "UseRoaringPointsToSet", "getUseRoaringPointsToSet()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ExtSettings.class, "hashVersion", "getHashVersion()I", 0)))};
        $$delegatedProperties = kPropertyArray;
        INSTANCE = new ExtSettings();
        ExtSettingsKt.access$getLogger$p().info(ExtSettings::_init_$lambda$0);
        dataFlowIteratorCountForAppClasses$delegate = (ReadWriteProperty)INSTANCE.getIntProperty(12, 1, Integer.MAX_VALUE).provideDelegate((Object)INSTANCE, $$delegatedProperties[0]);
        dataFlowIteratorCountForLibClasses$delegate = (ReadWriteProperty)INSTANCE.getIntProperty(8, 1, Integer.MAX_VALUE).provideDelegate((Object)INSTANCE, $$delegatedProperties[1]);
        dataFlowIteratorIsFixPointSizeLimit$delegate = (ReadWriteProperty)INSTANCE.getIntProperty(4, 1, Integer.MAX_VALUE).provideDelegate((Object)INSTANCE, $$delegatedProperties[2]);
        dataFlowMethodUnitsSizeLimit$delegate = (ReadWriteProperty)INSTANCE.getIntProperty(1000, -1, Integer.MAX_VALUE).provideDelegate((Object)INSTANCE, $$delegatedProperties[3]);
        dataFlowCacheExpireAfterAccess$delegate = (ReadWriteProperty)INSTANCE.getLongProperty(30000L, 1L, Long.MAX_VALUE).provideDelegate((Object)INSTANCE, $$delegatedProperties[4]);
        dataFlowCacheMaximumWeight$delegate = (ReadWriteProperty)INSTANCE.getLongProperty(10000L, 1L, Long.MAX_VALUE).provideDelegate((Object)INSTANCE, $$delegatedProperties[5]);
        dataFlowCacheMaximumSizeFactor$delegate = (ReadWriteProperty)INSTANCE.getProperty((Comparable)Double.valueOf(5.0), new Triple((Object)1.0E-4, (Object)Double.MAX_VALUE, (Object)dataFlowCacheMaximumSizeFactor.2.INSTANCE), (Function1)dataFlowCacheMaximumSizeFactor.3.INSTANCE).provideDelegate((Object)INSTANCE, $$delegatedProperties[6]);
        calleeDepChainMaxNumForLibClassesInInterProceduraldataFlow$delegate = (ReadWriteProperty)INSTANCE.getIntProperty(5, -1, Integer.MAX_VALUE).provideDelegate((Object)INSTANCE, $$delegatedProperties[7]);
        dataFlowInterProceduralCalleeDepChainMaxNum$delegate = (ReadWriteProperty)INSTANCE.getLongProperty(30L, -1L, Long.MAX_VALUE).provideDelegate((Object)INSTANCE, $$delegatedProperties[8]);
        dataFlowInterProceduralCalleeTimeOut$delegate = (ReadWriteProperty)INSTANCE.getIntProperty(30000, -1, Integer.MAX_VALUE).provideDelegate((Object)INSTANCE, $$delegatedProperties[9]);
        dataFlowResolveTargetsMaxNum$delegate = (ReadWriteProperty)INSTANCE.getLongProperty(8L, -1L, Long.MAX_VALUE).provideDelegate((Object)INSTANCE, $$delegatedProperties[10]);
        dataFlowResultPathOnlyStmt$delegate = (ReadWriteProperty)INSTANCE.getBooleanProperty(true).provideDelegate((Object)INSTANCE, $$delegatedProperties[11]);
        enableProcessBar$delegate = (ReadWriteProperty)INSTANCE.getBooleanProperty(true).provideDelegate((Object)INSTANCE, $$delegatedProperties[12]);
        showMetadata$delegate = (ReadWriteProperty)INSTANCE.getBooleanProperty(true).provideDelegate((Object)INSTANCE, $$delegatedProperties[13]);
        tabSize$delegate = (ReadWriteProperty)INSTANCE.getIntProperty(4).provideDelegate((Object)INSTANCE, $$delegatedProperties[14]);
        dumpCompleteDotCg$delegate = (ReadWriteProperty)INSTANCE.getBooleanProperty(false).provideDelegate((Object)INSTANCE, $$delegatedProperties[15]);
        prettyPrintJsonReport$delegate = (ReadWriteProperty)INSTANCE.getBooleanProperty(true).provideDelegate((Object)INSTANCE, $$delegatedProperties[16]);
        prettyPrintPlistReport$delegate = (ReadWriteProperty)INSTANCE.getBooleanProperty(false).provideDelegate((Object)INSTANCE, $$delegatedProperties[17]);
        sqliteJournalMode$delegate = (ReadWriteProperty)INSTANCE.getStringProperty("WAL").provideDelegate((Object)INSTANCE, $$delegatedProperties[18]);
        jdCoreDecompileTimeOut$delegate = (ReadWriteProperty)INSTANCE.getIntProperty(20000, -1, Integer.MAX_VALUE).provideDelegate((Object)INSTANCE, $$delegatedProperties[19]);
        skip_large_class_by_maximum_methods$delegate = (ReadWriteProperty)INSTANCE.getIntProperty(2000, -1, Integer.MAX_VALUE).provideDelegate((Object)INSTANCE, $$delegatedProperties[20]);
        skip_large_class_by_maximum_fields$delegate = (ReadWriteProperty)INSTANCE.getIntProperty(2000, -1, Integer.MAX_VALUE).provideDelegate((Object)INSTANCE, $$delegatedProperties[21]);
        castNeverFailsOfPhantomClass$delegate = (ReadWriteProperty)INSTANCE.getBooleanProperty(false).provideDelegate((Object)INSTANCE, $$delegatedProperties[22]);
        printAliasInfo$delegate = (ReadWriteProperty)INSTANCE.getBooleanProperty(false).provideDelegate((Object)INSTANCE, $$delegatedProperties[23]);
        UseRoaringPointsToSet$delegate = (ReadWriteProperty)INSTANCE.getBooleanProperty(false).provideDelegate((Object)INSTANCE, $$delegatedProperties[24]);
        hashVersion$delegate = (ReadWriteProperty)INSTANCE.getIntProperty(2).provideDelegate((Object)INSTANCE, $$delegatedProperties[25]);
    }
}

