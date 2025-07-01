package cn.sast.dataflow.infoflow.provider;

import soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinitionProvider;

@FunctionalInterface
public interface LazyMultiSourceSinkProviderKt {
    ISourceSinkDefinitionProvider get();
}