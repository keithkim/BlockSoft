package org.blockserver.soft.util;

/**
 * A Thread wrapper that is designed for short tasks.
 */
public abstract class Worker implements Runnable{
    private Thread thread;
    private String name;

    public Worker(String name){
        this.name = name;
    }

    /**
     * Start this worker.
     */
    public void startWorker(){
        thread = new Thread(this);
        thread.setName("Worker-"+name);
        thread.start();
    }

    @Deprecated
    /**
     * Stop this worker using Thread.stop();
     * Deprecated, use waitForWorkerToStop();
     */
    public void stopWorker(){
        thread.stop();
    }

    /**
     * Wait for this worker to stop.
     * @throws java.lang.InterruptedException If interrupted.
     */
    public void waitForWorkerToStop() throws InterruptedException {
        thread.join();
    }
}
