package com.feysh.corax.config.api;

import com.feysh.corax.config.api.AnalysisApi;
import com.feysh.corax.config.api.IAnalysisDepends;
import com.feysh.corax.config.api.IClassDecl;
import com.feysh.corax.config.api.IClassMatch;
import com.feysh.corax.config.api.IFieldDecl;
import com.feysh.corax.config.api.IFieldMatch;
import com.feysh.corax.config.api.IIMethodDecl0;
import com.feysh.corax.config.api.IIMethodDecl1;
import com.feysh.corax.config.api.IIMethodDecl10;
import com.feysh.corax.config.api.IIMethodDecl11;
import com.feysh.corax.config.api.IIMethodDecl12;
import com.feysh.corax.config.api.IIMethodDecl13;
import com.feysh.corax.config.api.IIMethodDecl14;
import com.feysh.corax.config.api.IIMethodDecl15;
import com.feysh.corax.config.api.IIMethodDecl16;
import com.feysh.corax.config.api.IIMethodDecl2;
import com.feysh.corax.config.api.IIMethodDecl3;
import com.feysh.corax.config.api.IIMethodDecl4;
import com.feysh.corax.config.api.IIMethodDecl5;
import com.feysh.corax.config.api.IIMethodDecl6;
import com.feysh.corax.config.api.IIMethodDecl7;
import com.feysh.corax.config.api.IIMethodDecl8;
import com.feysh.corax.config.api.IIMethodDecl9;
import com.feysh.corax.config.api.ILocalVarDecl;
import com.feysh.corax.config.api.ILocalVarMatch;
import com.feysh.corax.config.api.IMethodDecl;
import com.feysh.corax.config.api.IMethodMatch;
import com.feysh.corax.config.api.IRawMethodDecl;
import com.feysh.corax.config.api.ISMethodDecl0;
import com.feysh.corax.config.api.ISMethodDecl1;
import com.feysh.corax.config.api.ISMethodDecl10;
import com.feysh.corax.config.api.ISMethodDecl11;
import com.feysh.corax.config.api.ISMethodDecl12;
import com.feysh.corax.config.api.ISMethodDecl13;
import com.feysh.corax.config.api.ISMethodDecl14;
import com.feysh.corax.config.api.ISMethodDecl15;
import com.feysh.corax.config.api.ISMethodDecl16;
import com.feysh.corax.config.api.ISMethodDecl2;
import com.feysh.corax.config.api.ISMethodDecl3;
import com.feysh.corax.config.api.ISMethodDecl4;
import com.feysh.corax.config.api.ISMethodDecl5;
import com.feysh.corax.config.api.ISMethodDecl6;
import com.feysh.corax.config.api.ISMethodDecl7;
import com.feysh.corax.config.api.ISMethodDecl8;
import com.feysh.corax.config.api.ISMethodDecl9;
import com.feysh.corax.config.api.ISootClassDecl;
import com.feysh.corax.config.api.ISootFieldDecl;
import com.feysh.corax.config.api.ISootLocalVarDecl;
import com.feysh.corax.config.api.ISootMethodDecl;
import com.feysh.corax.config.api.PreAnalysisApi;
import com.feysh.corax.config.api.utils.UtilsKt;
import java.util.Map;
import mu.KLogger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.jetbrains.annotations.NotNull;
import org.slf4j.event.Level;
import soot.SootClass;

public interface AIAnalysisApi extends AnalysisApi, IAnalysisDepends {

    @NotNull
    Map<String, Object> getState();

    @NotNull
    PreAnalysisApi getPreAnalysis();

    @NotNull
    KLogger getLogger();

    void setVerbosity(@NotNull org.slf4j.event.Level verbosity);

    @NotNull
    Error getError();

    void validate();

    @NotNull
    <This> IIMethodDecl0<This, This> constructor(@NotNull Function0<? extends This> at);

    @NotNull
    <R, THIS> IIMethodDecl0<R, THIS> method(@NotNull Function1<? super THIS, ? extends R> at);

    @NotNull
    <R> ISMethodDecl0<R> staticMethod(@NotNull Function0<? extends R> at);

    @NotNull
    <This, P0> IIMethodDecl1<This, This, P0> constructor(@NotNull Function1<? super P0, ? extends This> at);

    @NotNull
    <R, THIS, P0> IIMethodDecl1<R, THIS, P0> method(@NotNull Function2<? super THIS, ? super P0, ? extends R> at);

    @NotNull
    <R, P0> ISMethodDecl1<R, P0> staticMethod(@NotNull Function1<? super P0, ? extends R> at);

    @NotNull
    <This, P0, P1> IIMethodDecl2<This, This, P0, P1> constructor(@NotNull Function2<? super P0, ? super P1, ? extends This> at);

    @NotNull
    <R, THIS, P0, P1> IIMethodDecl2<R, THIS, P0, P1> method(@NotNull Function3<? super THIS, ? super P0, ? super P1, ? extends R> at);

    @NotNull
    <R, P0, P1> ISMethodDecl2<R, P0, P1> staticMethod(@NotNull Function2<? super P0, ? super P1, ? extends R> at);

    @NotNull
    <This, P0, P1, P2> IIMethodDecl3<This, This, P0, P1, P2> constructor(@NotNull Function3<? super P0, ? super P1, ? super P2, ? extends This> at);

    @NotNull
    <R, THIS, P0, P1, P2> IIMethodDecl3<R, THIS, P0, P1, P2> method(@NotNull Function4<? super THIS, ? super P0, ? super P1, ? super P2, ? extends R> at);

    @NotNull
    <R, P0, P1, P2> ISMethodDecl3<R, P0, P1, P2> staticMethod(@NotNull Function3<? super P0, ? super P1, ? super P2, ? extends R> at);

    @NotNull
    <This, P0, P1, P2, P3> IIMethodDecl4<This, This, P0, P1, P2, P3> constructor(@NotNull Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends This> at);

    @NotNull
    <R, THIS, P0, P1, P2, P3> IIMethodDecl4<R, THIS, P0, P1, P2, P3> method(@NotNull Function5<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? extends R> at);

    @NotNull
    <R, P0, P1, P2, P3> ISMethodDecl4<R, P0, P1, P2, P3> staticMethod(@NotNull Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> at);

    @NotNull
    <This, P0, P1, P2, P3, P4> IIMethodDecl5<This, This, P0, P1, P2, P3, P4> constructor(@NotNull Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends This> at);

    @NotNull
    <R, THIS, P0, P1, P2, P3, P4> IIMethodDecl5<R, THIS, P0, P1, P2, P3, P4> method(@NotNull Function6<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> at);

    @NotNull
    <R, P0, P1, P2, P3, P4> ISMethodDecl5<R, P0, P1, P2, P3, P4> staticMethod(@NotNull Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> at);

    @NotNull
    <This, P0, P1, P2, P3, P4, P5> IIMethodDecl6<This, This, P0, P1, P2, P3, P4, P5> constructor(@NotNull Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends This> at);

    @NotNull
    <R, THIS, P0, P1, P2, P3, P4, P5> IIMethodDecl6<R, THIS, P0, P1, P2, P3, P4, P5> method(@NotNull Function7<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> at);

    @NotNull
    <R, P0, P1, P2, P3, P4, P5> ISMethodDecl6<R, P0, P1, P2, P3, P4, P5> staticMethod(@NotNull Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> at);

    @NotNull
    <This, P0, P1, P2, P3, P4, P5, P6> IIMethodDecl7<This, This, P0, P1, P2, P3, P4, P5, P6> constructor(@NotNull Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends This> at);

    @NotNull
    <R, THIS, P0, P1, P2, P3, P4, P5, P6> IIMethodDecl7<R, THIS, P0, P1, P2, P3, P4, P5, P6> method(@NotNull Function8<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> at);

    @NotNull
    <R, P0, P1, P2, P3, P4, P5, P6> ISMethodDecl7<R, P0, P1, P2, P3, P4, P5, P6> staticMethod(@NotNull Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> at);

    @NotNull
    <This, P0, P1, P2, P3, P4, P5, P6, P7> IIMethodDecl8<This, This, P0, P1, P2, P3, P4, P5, P6, P7> constructor(@NotNull Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends This> at);

    @NotNull
    <R, THIS, P0, P1, P2, P3, P4, P5, P6, P7> IIMethodDecl8<R, THIS, P0, P1, P2, P3, P4, P5, P6, P7> method(@NotNull Function9<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> at);

    @NotNull
    <R, P0, P1, P2, P3, P4, P5, P6, P7> ISMethodDecl8<R, P0, P1, P2, P3, P4, P5, P6, P7> staticMethod(@NotNull Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> at);

    @NotNull
    <This, P0, P1, P2, P3, P4, P5, P6, P7, P8> IIMethodDecl9<This, This, P0, P1, P2, P3, P4, P5, P6, P7, P8> constructor(@NotNull Function9<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? extends This> at);

    @NotNull
    <R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8> IIMethodDecl9<R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8> method(@NotNull Function10<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? extends R> at);

    @NotNull
    <R, P0, P1, P2, P3, P4, P5, P6, P7, P8> ISMethodDecl9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8> staticMethod(@NotNull Function9<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? extends R> at);

    @NotNull
    <This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> IIMethodDecl10<This, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> constructor(@NotNull Function10<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? extends This> at);

    @NotNull
    <R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> IIMethodDecl10<R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> method(@NotNull Function11<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? extends R> at);

    @NotNull
    <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> ISMethodDecl10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> staticMethod(@NotNull Function10<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? extends R> at);

    @NotNull
    <This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> IIMethodDecl11<This, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> constructor(@NotNull Function11<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? extends This> at);

    @NotNull
    <R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> IIMethodDecl11<R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> method(@NotNull Function12<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? extends R> at);

    @NotNull
    <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> ISMethodDecl11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> staticMethod(@NotNull Function11<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? extends R> at);

    @NotNull
    <This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> IIMethodDecl12<This, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> constructor(@NotNull Function12<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? extends This> at);

    @NotNull
    <R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> IIMethodDecl12<R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> method(@NotNull Function13<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? extends R> at);

    @NotNull
    <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> ISMethodDecl12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> staticMethod(@NotNull Function12<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? extends R> at);

    @NotNull
    <This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IIMethodDecl13<This, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> constructor(@NotNull Function13<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? extends This> at);

    @NotNull
    <R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IIMethodDecl13<R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> method(@NotNull Function14<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? extends R> at);

    @NotNull
    <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> ISMethodDecl13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> staticMethod(@NotNull Function13<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? extends R> at);

    @NotNull
    <This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> IIMethodDecl14<This, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> constructor(@NotNull Function14<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? extends This> at);

    @NotNull
    <R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> IIMethodDecl14<R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> method(@NotNull Function15<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? extends R> at);

    @NotNull
    <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> ISMethodDecl14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> staticMethod(@NotNull Function14<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? extends R> at);

    @NotNull
    <This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> IIMethodDecl15<This, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> constructor(@NotNull Function15<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? extends This> at);

    @NotNull
    <R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> IIMethodDecl15<R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> method(@NotNull Function16<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? extends R> at);

    @NotNull
    <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> ISMethodDecl15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> staticMethod(@NotNull Function15<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? extends R> at);

    @NotNull
    <This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> IIMethodDecl16<This, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> constructor(@NotNull Function16<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? super P15, ? extends This> at);

    @NotNull
    <R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> IIMethodDecl16<R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> method(@NotNull Function17<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? super P15, ? extends R> at);

    @NotNull
    <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> ISMethodDecl16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> staticMethod(@NotNull Function16<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? super P15, ? extends R> at);

    @NotNull
    <V> IFieldDecl<Object, V> field(@NotNull KProperty<? extends V> property);

    void eachClass(@NotNull Function1<? super ISootClassDecl, Unit> block);

    void eachMethod(@NotNull Function1<? super ISootMethodDecl<Object>, Unit> block);

    void eachField(@NotNull Function1<? super ISootFieldDecl<Object, Object>, Unit> block);

    void eachLocalVariable(@NotNull Function1<? super ISootLocalVarDecl<Object>, Unit> block);

    @NotNull
    IClassDecl clazz(@NotNull IClassMatch match);

    @NotNull
    IRawMethodDecl<Object> method(@NotNull IMethodMatch match);

    @NotNull
    IFieldDecl<Object, Object> field(@NotNull IFieldMatch match);

    @NotNull
    ILocalVarDecl<Object> localVar(@NotNull ILocalVarMatch match);

    @NotNull
    <R> Sequence<ISootMethodDecl<R>> getSootDecl(@NotNull IMethodDecl<R> decl);

    @NotNull
    ISootClassDecl sootClass(@NotNull SootClass clazz);

    interface Error {
        void error(@NotNull String msg);
        void warning(@NotNull String msg);
        @NotNull KLogger getLogger();
    }
}