// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 2012-8-30 12:02:48
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   GumballMachine_Stub.java

package test.zhangdy;

import java.lang.reflect.Method;
import java.rmi.*;
import java.rmi.server.*;

// Referenced classes of package test.zhangdy:
//            GumballMachineRemote, State

public final class GumballMachine_Stub extends RemoteStub
    implements GumballMachineRemote, Remote
{

    public GumballMachine_Stub(RemoteRef remoteref)
    {
        super(remoteref);
    }

    static Class _mthclass$(String s)
    {
        try
        {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    public int getCount()
        throws RemoteException
    {
        try
        {
            Object obj = super.ref.invoke(this, $method_getCount_0, null, 0x4b2605c0ac717221L);
            return ((Integer)obj).intValue();
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public String getLocation()
        throws RemoteException
    {
        try
        {
            Object obj = super.ref.invoke(this, $method_getLocation_1, null, 0x23e7cf072f16a270L);
            return (String)obj;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public State getState()
        throws RemoteException
    {
        try
        {
            Object obj = super.ref.invoke(this, $method_getState_2, null, 0x5c397319fde3e779L);
            return (State)obj;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    private static final long serialVersionUID = 2L;
    private static Method $method_getCount_0;
    private static Method $method_getLocation_1;
    private static Method $method_getState_2;

    static 
    {
        try
        {
            $method_getCount_0 = (test.zhangdy.GumballMachineRemote.class).getMethod("getCount", new Class[0]);
            $method_getLocation_1 = (test.zhangdy.GumballMachineRemote.class).getMethod("getLocation", new Class[0]);
            $method_getState_2 = (test.zhangdy.GumballMachineRemote.class).getMethod("getState", new Class[0]);
        }
        catch(NoSuchMethodException _ex)
        {
            throw new NoSuchMethodError("stub class initialization failed");
        }
    }
}
