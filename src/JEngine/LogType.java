package JEngine;

public enum LogType {

    MESSAGE(0),
    WARNING(1),
    ERROR(2);

    final int code;

    LogType(int _code) {
        code = _code;
    }

}
