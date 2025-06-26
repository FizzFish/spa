/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.AbstractBugEnv
 *  cn.sast.api.report.BugPathEvent
 *  cn.sast.api.report.BugPathEventEnvironment
 *  cn.sast.api.report.ClassResInfo
 *  cn.sast.api.report.FileResInfo
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.common.Resource
 *  com.feysh.corax.cache.analysis.SootInfoCache
 *  com.feysh.corax.config.api.BugMessage$Env
 *  com.feysh.corax.config.api.Language
 *  com.feysh.corax.config.api.report.Region
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.tagkit.Host
 */
package cn.sast.api.report;

import cn.sast.api.report.BugPathEvent;
import cn.sast.api.report.BugPathEventEnvironment;
import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.FileResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.common.Resource;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.report.Region;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.tagkit.Host;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J,\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J.\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0013\u001a\u00020\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R.\u0010\u0004\u001a\u001f\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0002`\n\u00a2\u0006\u0002\b\t0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2={"Lcn/sast/api/report/AbstractBugEnv;", "Lcom/feysh/corax/config/api/BugMessage$Env;", "<init>", "()V", "appendEvents", "", "Lkotlin/Function1;", "Lcn/sast/api/report/BugPathEventEnvironment;", "Lcn/sast/api/report/BugPathEvent;", "Lkotlin/ExtensionFunctionType;", "Lcn/sast/api/report/BugPathEventLazyGen;", "getAppendEvents", "()Ljava/util/List;", "appendPathEvent", "", "message", "", "Lcom/feysh/corax/config/api/Language;", "", "loc", "Ljava/nio/file/Path;", "region", "Lcom/feysh/corax/config/api/report/Region;", "Lsoot/tagkit/Host;", "corax-api"})
@SourceDebugExtension(value={"SMAP\nReport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Report.kt\ncn/sast/api/report/AbstractBugEnv\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,451:1\n1#2:452\n*E\n"})
public abstract class AbstractBugEnv
implements BugMessage.Env {
    @NotNull
    private final List<Function1<BugPathEventEnvironment, BugPathEvent>> appendEvents = new ArrayList();

    @NotNull
    public final List<Function1<BugPathEventEnvironment, BugPathEvent>> getAppendEvents() {
        return this.appendEvents;
    }

    public void appendPathEvent(@NotNull Map<Language, String> message, @NotNull Path loc, @NotNull Region region) {
        Intrinsics.checkNotNullParameter(message, (String)"message");
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        ((Collection)this.appendEvents).add(arg_0 -> AbstractBugEnv.appendPathEvent$lambda$0(message, loc, region, arg_0));
    }

    public void appendPathEvent(@NotNull Map<Language, String> message, @NotNull Host loc, @Nullable Region region) {
        Intrinsics.checkNotNullParameter(message, (String)"message");
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        ((Collection)this.appendEvents).add(arg_0 -> AbstractBugEnv.appendPathEvent$lambda$2(region, message, loc, arg_0));
    }

    private static final BugPathEvent appendPathEvent$lambda$0(Map $message, Path $loc, Region $region, BugPathEventEnvironment bugPathEventEnvironment) {
        Intrinsics.checkNotNullParameter((Object)bugPathEventEnvironment, (String)"<this>");
        return new BugPathEvent($message, (IBugResInfo)new FileResInfo(Resource.INSTANCE.fileOf($loc)), $region, null, 8, null);
    }

    private static final BugPathEvent appendPathEvent$lambda$2(Region $region, Map $message, Host $loc, BugPathEventEnvironment $this$ret) {
        Intrinsics.checkNotNullParameter((Object)$this$ret, (String)"$this$ret");
        Region region = $region;
        if (region == null) {
            Region region2;
            SootInfoCache sootInfoCache = $this$ret.getSootInfoCache();
            if (sootInfoCache != null) {
                SootInfoCache it = sootInfoCache;
                boolean bl = false;
                region2 = Region.Companion.invoke(it, $loc);
            } else {
                region2 = region = null;
            }
            if (region2 == null) {
                region = Region.Companion.getERROR();
            }
        }
        Region selectRegion = region;
        return new BugPathEvent($message, (IBugResInfo)ClassResInfo.Companion.of($loc), selectRegion, null, 8, null);
    }
}

