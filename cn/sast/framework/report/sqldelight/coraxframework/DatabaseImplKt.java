/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.cash.sqldelight.db.QueryResult$Value
 *  app.cash.sqldelight.db.SqlDriver
 *  app.cash.sqldelight.db.SqlSchema
 *  cn.sast.framework.report.sqldelight.Database
 *  cn.sast.framework.report.sqldelight.coraxframework.DatabaseImpl
 *  cn.sast.framework.report.sqldelight.coraxframework.DatabaseImpl$Schema
 *  cn.sast.framework.report.sqldelight.coraxframework.DatabaseImplKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.report.sqldelight.coraxframework;

import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlSchema;
import cn.sast.framework.report.sqldelight.Database;
import cn.sast.framework.report.sqldelight.coraxframework.DatabaseImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\b\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\nH\u0000\"*\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00050\u00048@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2={"schema", "Lapp/cash/sqldelight/db/SqlSchema;", "Lapp/cash/sqldelight/db/QueryResult$Value;", "", "Lkotlin/reflect/KClass;", "Lcn/sast/framework/report/sqldelight/Database;", "getSchema", "(Lkotlin/reflect/KClass;)Lapp/cash/sqldelight/db/SqlSchema;", "newInstance", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "corax-framework"})
public final class DatabaseImplKt {
    @NotNull
    public static final SqlSchema<QueryResult.Value<Unit>> getSchema(@NotNull KClass<Database> $this$schema) {
        Intrinsics.checkNotNullParameter($this$schema, (String)"<this>");
        return (SqlSchema)DatabaseImpl.Schema.INSTANCE;
    }

    @NotNull
    public static final Database newInstance(@NotNull KClass<Database> $this$newInstance, @NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter($this$newInstance, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        return (Database)new DatabaseImpl(driver);
    }
}

