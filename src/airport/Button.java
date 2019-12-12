package airport;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// La clase Paso define un cerrojo con un Condition para la variable booleana cerrado
// que es comprobada por un proceso.
// Si vale false(abierto) el proceso puede continuar. Si es true(cerrado) el proceso se detiene
public class Button
{
    private boolean close=false;
    private final Lock lock_e1 = new ReentrantLock();
    private final Lock lock_e2 = new ReentrantLock();
    private final Lock lock_global = new ReentrantLock();
    private final Condition stop_e1 = lock_e1.newCondition();
    private final Condition stop_e2 = lock_e2.newCondition();
    private final Condition stop_global = lock_global.newCondition();
    private boolean close_e1 = false;
    private boolean close_e2 = false;
    private boolean close_global = false;

    public void CheckStopE1() {
        try {
            lock_e1.lock();
            while (close_e1) {
                try {
                    stop_e1.await();
                } catch (final InterruptedException ie) {
                }
            }
        } finally {
            lock_e1.unlock();
        }
    }

    public void CheckStopE2() {
        try {
            lock_e2.lock();
            while (close_e2) {
                try {
                    stop_e2.await();
                } catch (final InterruptedException ie) {
                }
            }
        } finally {
            lock_e2.unlock();
        }
    }

    public void CheckStopAll() {
        try {
            lock_global.lock();
            while (close_global) {
                try {
                    stop_global.await();
                } catch (final InterruptedException ie) {
                }
            }
            
        }
        finally
        {
            lock_global.unlock();
        }
    }

    public void SetPause1(){
        close_e1 = true;
    }

    public void Resume1(){
        try{
            lock_e1.lock();
            close_e1 = false;
            stop_e1.signal();
        }
        finally {
            lock_e1.unlock();
        }
    }

    public void SetPause2(){
        close_e2 = true;
    }

    public void Resume2(){
        try{
            lock_e2.lock();
            close_e2 = false;
            stop_e2.signal();
        }
        finally {
            lock_e2.unlock();
        }
    }

    public void SetPauseAll(){
        close_global = true;
    }

    public void ResumeAll(){
        try{
            lock_global.lock();
            close_global = false;
            stop_global.signalAll();
        }
        finally {
            lock_global.unlock();
        }
    }

}
