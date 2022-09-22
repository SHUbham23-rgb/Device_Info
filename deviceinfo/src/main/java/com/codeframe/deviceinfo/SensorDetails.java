package com.codeframe.deviceinfo;

public class SensorDetails {
    String name;
    int id;
    float power;
    float resolution;
    int type;
    String vendor;
    int version;

    public SensorDetails(String name, int id, float power, float resolution, int type, String vendor, int version) {
        this.name = name;
        this.id = id;
        this.power = power;
        this.resolution = resolution;
        this.type = type;
        this.vendor = vendor;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public float getPower() {
        return power;
    }

    public float getResolution() {
        return resolution;
    }

    public int getType() {
        return type;
    }

    public String getVendor() {
        return vendor;
    }

    public int getVersion() {
        return version;
    }
}