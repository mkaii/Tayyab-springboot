package be.kdg.backendfrontend.Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArduinoDevice {
    private int deviceID;
    private DeviceType deviceType;
    private List<Data> dataList;

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "ArduinoDevice{" + "deviceID='" + deviceID + '\'' + ", deviceType=" + deviceType + '}';
    }

    public int getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public ArduinoDevice(int deviceID, DeviceType deviceType) {
        this.deviceID = deviceID;
        this.deviceType = deviceType;
    }

    public ArduinoDevice(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

}
