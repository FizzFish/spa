package cn.sast.framework.result;

import cn.sast.api.report.IResultCollector;

public interface IUTBotResultCollector extends IResultCollector {
    void addUtState();
}