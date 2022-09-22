package com.codeframe.deviceinfo;

import static android.content.Context.SENSOR_SERVICE;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.topjohnwu.superuser.Shell;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Info {
    private static Info info;
    String board = Build.BOARD;
    String bootloader = Build.BOOTLOADER;
    String brand = Build.BRAND;
    String device = Build.DEVICE;
    String display = Build.DISPLAY;
    String fingerprint = Build.FINGERPRINT;
    String hardware = Build.HARDWARE;
    String host = Build.HOST;
    String id = Build.ID;
    String manufacturer = Build.MANUFACTURER;
    String model = Build.MODEL;
    //        String socManufacturer = Build.SOC_MANUFACTURER;
//        String socModel = Build.SOC_MODEL;
    String user = Build.USER;
    String partitionNameSystem = Build.Partition.PARTITION_NAME_SYSTEM;
    String securityPatch = Build.VERSION.SECURITY_PATCH;
    String radioVersion = Build.getRadioVersion();
    List<SensorDetails> sensorDetailsList;
    private String linuxVersion;
    private WeakReference<Context> contextWeakReference;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Info() {
        linuxVersion = Shell.cmd("cat /proc/version").exec().getOut().toString();
        sensorDetailsList = new ArrayList<>();
        SensorManager sm = (SensorManager) contextWeakReference.get().getSystemService(SENSOR_SERVICE);
        List<Sensor> dynamicSensorList = sm.getSensorList(Sensor.TYPE_ALL);
        for (int i = 0; i < dynamicSensorList.size(); i++) {
            Sensor sensor = dynamicSensorList.get(i);
            sensorDetailsList.add(new SensorDetails(sensor.getName()
                    , sensor.getId()
                    , sensor.getPower()
                    , sensor.getResolution()
                    , sensor.getType()
                    , sensor.getVendor()
                    , sensor.getVersion()));

        }


    }

    public static Info getInstance() {
        if (info == null) {
            info = new Info();
        }
        return info;
    }

    public String getBoard() {
        return board;
    }

    public String getBootloader() {
        return bootloader;
    }

    public String getBrand() {
        return brand;
    }

    public String getDevice() {
        return device;
    }

    public String getDisplay() {
        return display;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public String getHardware() {
        return hardware;
    }

    public String getHost() {
        return host;
    }

    public String getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getUser() {
        return user;
    }

    public String getPartitionNameSystem() {
        return partitionNameSystem;
    }

    public String getSecurityPatch() {
        return securityPatch;
    }

    public String getRadioVersion() {
        return radioVersion;
    }

    public Info setContext(Context context) {
        contextWeakReference = new WeakReference<>(context);
        return info;
    }


}
