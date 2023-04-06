package com.example.sample.Util;

import com.example.sample.Processes.MQTTProcess;
import com.example.sample.Processes.NFCProcess;
import com.example.sample.Processes.RESTProcess;
import com.example.sample.Processes.SerialProcess;

public class WorkerProcess {
    private SerialProcess serialProcess;
    private NFCProcess nfcProcess;
    private MQTTProcess mqttProcess;
    private RESTProcess restProcess;

    public void startSerialProcess() {
        serialProcess = new SerialProcess();
        serialProcess.start();
    }

    public void startNFCProcess() {
        nfcProcess = new NFCProcess();
        nfcProcess.start();
    }

    public void startMQTTProcess() {
        mqttProcess = new MQTTProcess();
        mqttProcess.start();
    }

    public void startRESTProcess() {
        restProcess = new RESTProcess();
        restProcess.start();
    }

    public void stopAllProcesses() {
        if (serialProcess != null) {
            serialProcess.stop();
        }
        if (nfcProcess != null) {
            nfcProcess.stop();
        }
        if (mqttProcess != null) {
            mqttProcess.stop();
        }
        if (restProcess != null) {
            restProcess.stop();
        }
    }
}
