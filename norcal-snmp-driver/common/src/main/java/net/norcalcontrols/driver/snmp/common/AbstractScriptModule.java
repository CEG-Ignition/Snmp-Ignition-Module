package net.norcalcontrols.driver.snmp.common;

import com.inductiveautomation.ignition.common.BundleUtil;
import com.inductiveautomation.ignition.common.script.hints.ScriptArg;
import com.inductiveautomation.ignition.common.script.hints.ScriptFunction;

public abstract class AbstractScriptModule implements FunctionInterface {

    static {
        BundleUtil.get().addBundle(
                AbstractScriptModule.class.getSimpleName(),
                AbstractScriptModule.class.getClassLoader(),
                AbstractScriptModule.class.getName().replace('.', '/')
        );
    }

    @Override
    @ScriptFunction
    public String[] get(
            @ScriptArg("address") String addr,
            @ScriptArg("port") int port,
            @ScriptArg("OID") String[] OIDS,
            @ScriptArg("Others") String... params)
    {
        return NorcalSNMPDriverModule.snmpGet(addr, port, OIDS, params);
    }

    protected abstract String[] getImpl(String addr, int port, String[] OIDS, String... params);
    
    @Override
    @ScriptFunction
    public String[] getV3(
    		@ScriptArg("address") String addr,
    		@ScriptArg("port") int port,
    		@ScriptArg("OID") String[] OIDS,
    		@ScriptArg("authLevel") int authLevel,
    		@ScriptArg("user") String user,
    		@ScriptArg("pass") String pass,
    		@ScriptArg("Others") String... params)
    {
    	return NorcalSNMPDriverModule.snmpGetV3(addr, port, OIDS, authLevel, user, pass, params);
    }
    
    protected abstract String[] getImplV3(String addr, int port, String[] OIDS, int authLevel, String user, String pass, String... params); 
    
}