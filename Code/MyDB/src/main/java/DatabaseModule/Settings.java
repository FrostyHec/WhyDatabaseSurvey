package DatabaseModule;

import DatabaseModule.Engine.Engine;
import DatabaseModule.Engine.Impl.BPTreeEngine.BPTreeEngine;
import DatabaseModule.Engine.Impl.CSVEngine.CSVEngine;
import DatabaseModule.Engine.Impl.EngineType;
import lombok.Data;


public class Settings {
    private static LogType logType=LogType.None;
    private static String dataPath="DataSaved";
    private static EngineType engineType=EngineType.CSVEngine;
    public static Engine getEngine(){
        switch (engineType){
            case CSVEngine -> {
                return new CSVEngine();
            }
            case BPTreeEngine -> {
                return new BPTreeEngine();
            }
        }
        throw new RuntimeException("Engine not found!");
    }
    public static String getDataPath() {
        return dataPath;
    }

    public static LogType logType() {
        return logType;
    }
    public static void setLogType(LogType logDetails) {
        Settings.logType = logDetails;
    }
}
