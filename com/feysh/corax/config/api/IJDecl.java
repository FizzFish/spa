package com.feysh.corax.config.api;

public sealed interface IJDecl permits IClassDecl, IFieldDecl, ILocalVarDecl, IMethodDecl {
}