package com.yukiny.sleeplessmod.others.tick_manager;

public interface TickManagement {
    default void setValueToTickManager(Runnable runner, int delay){
        TickManager.runner.add(runner);
        TickManager.delay.add(delay);
        TickManager.delayCount.add(0);
    }

    default void setValueToTickManagerWithRender(Runnable runner, int delay){
        TickManager.renderRunner.add(runner);
        TickManager.renderDelay.add(delay);
        TickManager.renderDelayCount.add(0);
    }
}
