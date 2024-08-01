package SQLParseModule.Statements;

import DatabaseModule.Engine.Engine;
import DatabaseModule.Operations.Node;
import DatabaseModule.Settings;

public abstract class Statement implements Node {
    public abstract String next() throws Exception;
    private static Engine engine= Settings.getEngine();
    public Engine getEngine(){
        if(engine==null) throw new RuntimeException("Engine not set");
        return engine;
    }
    public static void setEngine(Engine engine) {
        Statement.engine =engine;
    }
}
