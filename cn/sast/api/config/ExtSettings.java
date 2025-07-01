package cn.sast.api.config;

import org.jetbrains.annotations.NotNull;
import org.utbot.common.AbstractSettings;

public final class ExtSettings extends AbstractSettings {
    public static final ExtSettings INSTANCE = new ExtSettings();

    private static final String DEFAULT_SETTINGS_PATH = "corax.settings.path";
    private static final String DEFAULT_SQLITE_JOURNAL_MODE = "WAL";

    // Configuration properties with default values
    private int dataFlowIteratorCountForAppClasses = 12;
    private int dataFlowIteratorCountForLibClasses = 8;
    private int dataFlowIteratorIsFixPointSizeLimit = 4;
    private int dataFlowMethodUnitsSizeLimit = 1000;
    private long dataFlowCacheExpireAfterAccess = 30000L;
    private long dataFlowCacheMaximumWeight = 10000L;
    private double dataFlowCacheMaximumSizeFactor = 5.0;
    private int calleeDepChainMaxNumForLibClassesInInterProceduraldataFlow = 5;
    private long dataFlowInterProceduralCalleeDepChainMaxNum = 30L;
    private int dataFlowInterProceduralCalleeTimeOut = 30000;
    private long dataFlowResolveTargetsMaxNum = 8L;
    private boolean dataFlowResultPathOnlyStmt = true;
    private boolean enableProcessBar = true;
    private boolean showMetadata = true;
    private int tabSize = 4;
    private boolean dumpCompleteDotCg = false;
    private boolean prettyPrintJsonReport = true;
    private boolean prettyPrintPlistReport = false;
    private String sqliteJournalMode = DEFAULT_SQLITE_JOURNAL_MODE;
    private int jdCoreDecompileTimeOut = 20000;
    private int skipLargeClassByMaximumMethods = 2000;
    private int skipLargeClassByMaximumFields = 2000;
    private boolean castNeverFailsOfPhantomClass = false;
    private boolean printAliasInfo = false;
    private boolean useRoaringPointsToSet = false;
    private int hashVersion = 2;

    private ExtSettings() {
        super(ExtSettingsKt.logger, DEFAULT_SETTINGS_PATH, ExtSettingsKt.defaultKeyForSettingsPath);
    }

    @NotNull
    public String defaultSettingsPath() {
        return ExtSettingsKt.defaultKeyForSettingsPath;
    }

    @NotNull
    public static String getPath() {
        String path = System.getProperty(DEFAULT_SETTINGS_PATH);
        return path != null ? path : ExtSettingsKt.defaultKeyForSettingsPath;
    }

    // Getters and setters
    public int getDataFlowIteratorCountForAppClasses() {
        return dataFlowIteratorCountForAppClasses;
    }

    public void setDataFlowIteratorCountForAppClasses(int value) {
        this.dataFlowIteratorCountForAppClasses = value;
    }

    public int getDataFlowIteratorCountForLibClasses() {
        return dataFlowIteratorCountForLibClasses;
    }

    public void setDataFlowIteratorCountForLibClasses(int value) {
        this.dataFlowIteratorCountForLibClasses = value;
    }

    public int getDataFlowIteratorIsFixPointSizeLimit() {
        return dataFlowIteratorIsFixPointSizeLimit;
    }

    public void setDataFlowIteratorIsFixPointSizeLimit(int value) {
        this.dataFlowIteratorIsFixPointSizeLimit = value;
    }

    public int getDataFlowMethodUnitsSizeLimit() {
        return dataFlowMethodUnitsSizeLimit;
    }

    public void setDataFlowMethodUnitsSizeLimit(int value) {
        this.dataFlowMethodUnitsSizeLimit = value;
    }

    public long getDataFlowCacheExpireAfterAccess() {
        return dataFlowCacheExpireAfterAccess;
    }

    public void setDataFlowCacheExpireAfterAccess(long value) {
        this.dataFlowCacheExpireAfterAccess = value;
    }

    public long getDataFlowCacheMaximumWeight() {
        return dataFlowCacheMaximumWeight;
    }

    public void setDataFlowCacheMaximumWeight(long value) {
        this.dataFlowCacheMaximumWeight = value;
    }

    public double getDataFlowCacheMaximumSizeFactor() {
        return dataFlowCacheMaximumSizeFactor;
    }

    public void setDataFlowCacheMaximumSizeFactor(double value) {
        this.dataFlowCacheMaximumSizeFactor = value;
    }

    public int getCalleeDepChainMaxNumForLibClassesInInterProceduraldataFlow() {
        return calleeDepChainMaxNumForLibClassesInInterProceduraldataFlow;
    }

    public void setCalleeDepChainMaxNumForLibClassesInInterProceduraldataFlow(int value) {
        this.calleeDepChainMaxNumForLibClassesInInterProceduraldataFlow = value;
    }

    public long getDataFlowInterProceduralCalleeDepChainMaxNum() {
        return dataFlowInterProceduralCalleeDepChainMaxNum;
    }

    public void setDataFlowInterProceduralCalleeDepChainMaxNum(long value) {
        this.dataFlowInterProceduralCalleeDepChainMaxNum = value;
    }

    public int getDataFlowInterProceduralCalleeTimeOut() {
        return dataFlowInterProceduralCalleeTimeOut;
    }

    public void setDataFlowInterProceduralCalleeTimeOut(int value) {
        this.dataFlowInterProceduralCalleeTimeOut = value;
    }

    public long getDataFlowResolveTargetsMaxNum() {
        return dataFlowResolveTargetsMaxNum;
    }

    public void setDataFlowResolveTargetsMaxNum(long value) {
        this.dataFlowResolveTargetsMaxNum = value;
    }

    public boolean getDataFlowResultPathOnlyStmt() {
        return dataFlowResultPathOnlyStmt;
    }

    public void setDataFlowResultPathOnlyStmt(boolean value) {
        this.dataFlowResultPathOnlyStmt = value;
    }

    public boolean getEnableProcessBar() {
        return enableProcessBar;
    }

    public void setEnableProcessBar(boolean value) {
        this.enableProcessBar = value;
    }

    public boolean getShowMetadata() {
        return showMetadata;
    }

    public void setShowMetadata(boolean value) {
        this.showMetadata = value;
    }

    public int getTabSize() {
        return tabSize;
    }

    public void setTabSize(int value) {
        this.tabSize = value;
    }

    public boolean getDumpCompleteDotCg() {
        return dumpCompleteDotCg;
    }

    public void setDumpCompleteDotCg(boolean value) {
        this.dumpCompleteDotCg = value;
    }

    public boolean getPrettyPrintJsonReport() {
        return prettyPrintJsonReport;
    }

    public void setPrettyPrintJsonReport(boolean value) {
        this.prettyPrintJsonReport = value;
    }

    public boolean getPrettyPrintPlistReport() {
        return prettyPrintPlistReport;
    }

    public void setPrettyPrintPlistReport(boolean value) {
        this.prettyPrintPlistReport = value;
    }

    @NotNull
    public String getSqliteJournalMode() {
        return sqliteJournalMode;
    }

    public void setSqliteJournalMode(@NotNull String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        this.sqliteJournalMode = value;
    }

    public int getJdCoreDecompileTimeOut() {
        return jdCoreDecompileTimeOut;
    }

    public void setJdCoreDecompileTimeOut(int value) {
        this.jdCoreDecompileTimeOut = value;
    }

    public int getSkip_large_class_by_maximum_methods() {
        return skipLargeClassByMaximumMethods;
    }

    public void setSkip_large_class_by_maximum_methods(int value) {
        this.skipLargeClassByMaximumMethods = value;
    }

    public int getSkip_large_class_by_maximum_fields() {
        return skipLargeClassByMaximumFields;
    }

    public void setSkip_large_class_by_maximum_fields(int value) {
        this.skipLargeClassByMaximumFields = value;
    }

    public boolean getCastNeverFailsOfPhantomClass() {
        return castNeverFailsOfPhantomClass;
    }

    public void setCastNeverFailsOfPhantomClass(boolean value) {
        this.castNeverFailsOfPhantomClass = value;
    }

    public boolean getPrintAliasInfo() {
        return printAliasInfo;
    }

    public void setPrintAliasInfo(boolean value) {
        this.printAliasInfo = value;
    }

    public boolean getUseRoaringPointsToSet() {
        return useRoaringPointsToSet;
    }

    public void setUseRoaringPointsToSet(boolean value) {
        this.useRoaringPointsToSet = value;
    }

    public int getHashVersion() {
        return hashVersion;
    }

    public void setHashVersion(int value) {
        this.hashVersion = value;
    }

    static {
        ExtSettingsKt.logger.info("ExtSettingsPath: " + getPath());
    }
}