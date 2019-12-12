package airport;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// La clase Paso define un cerrojo con un Condition para la variable booleana cerrado
// que es comprobada por un proceso.
// Si vale false(abierto) el proceso puede continuar. Si es true(cerrado) el proceso se detiene
public class Button
{
    private boolean close=false;
    private Lock lockbutton = new ReentrantLock();
    private Condition stop = lockbutton.newCondition();

    public void checkpress()
    {
        try
        {
            lockbutton.lock();
            while(close)
            {
                try
                {
                    stop.await();
                } catch(InterruptedException ie){ }
            }
        }
        finally
        {
            lockbutton.unlock();
        }
    }
    
    public void keepgoing()
    {
        try
        {
            lockbutton.lock();
            close=false;
            stop.signalAll();
        }
        finally
        {
            lockbutton.unlock();
        }
    }
    
    public void stopbutton()
    {
        try
        {
            lockbutton.lock();
            close=true;
            
            
            
        }
        finally
        {
            lockbutton.unlock();
        }
    }
}
