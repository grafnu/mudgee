/*
 * Copyright (c) 2018, UNSW. (https://www.unsw.edu.au/) All Rights Reserved.
 *
 * UNSW. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.mudgee.generator.vswitch;

import java.io.Serializable;

public class OFFlow implements Serializable{
    private String srcMac="*";
    private String dstMac="*";
    private String ethType="*";
    private String vlanId="*";
    private String srcIp="*";
    private String dstIp="*";
    private String ipProto="*";
    private String srcPort="*";
    private String dstPort="*";
    private String icmpType="*";
    private String icmpCode="*";
    //duration needs to be manually calculated from controller
    private long createdTimestamp;
    private OFAction ofAction;
    private int priority;
    private long volumeTransmitted = 0;
    private long packetCount = 0;
    private long idleTimeOut = 0;
    private long lastPacketTransmittedTime;

    public OFFlow copy() {
        OFFlow ofFlow = new OFFlow();
        ofFlow.setSrcMac(this.srcMac);
        ofFlow.setDstMac(this.dstMac);
        ofFlow.setEthType(this.ethType);
        ofFlow.setVlanId(this.vlanId);
        ofFlow.setSrcIp(this.srcIp);
        ofFlow.setDstIp(this.dstIp);
        ofFlow.setIpProto(this.ipProto);
        ofFlow.setSrcPort(this.srcPort);
        ofFlow.setDstPort(this.dstPort);
        ofFlow.setPriority(this.priority);
        ofFlow.setIcmpType(this.icmpType);
        ofFlow.setIcmpCode(this.icmpCode);
        return ofFlow;
    }

    public long getPacketCount() {
        return packetCount;
    }

    public void setPacketCount(long packetCount) {
        this.packetCount = packetCount;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public enum OFAction {
        MIRROR_TO_CONTROLLER,
        NORMAL
    }

    public OFAction getOfAction() {
        return ofAction;
    }

    public void setOfAction(OFAction ofAction) {
        this.ofAction = ofAction;
    }

    public String getSrcMac() {
        return srcMac;
    }

    public void setSrcMac(String srcMac) {
        this.srcMac = srcMac;
    }

    public String getDstMac() {
        return dstMac;
    }

    public void setDstMac(String dstMac) {
        this.dstMac = dstMac;
    }

    public String getEthType() {
        return ethType;
    }

    public void setEthType(String ethType) {
        this.ethType = ethType;
    }

    public String getVlanId() {
        return vlanId;
    }

    public void setVlanId(String vlanId) {
        this.vlanId = vlanId;
    }

    public String getSrcIp() {
        return srcIp;
    }

    public void setSrcIp(String srcIp) {
        this.srcIp = srcIp;
    }

    public String getDstIp() {
        return dstIp;
    }

    public void setDstIp(String dstIp) {
        this.dstIp = dstIp;
    }

    public String getIpProto() {
        return ipProto;
    }

    public void setIpProto(String ipProto) {
        this.ipProto = ipProto;
    }

    public String getSrcPort() {
        return srcPort;
    }

    public void setSrcPort(String srcPort) {
        this.srcPort = srcPort;
    }

    public String getDstPort() {
        return dstPort;
    }

    public void setDstPort(String dstPort) {
        this.dstPort = dstPort;
    }

    @Override
    public int hashCode() {
        int result = this.srcMac.hashCode();
        result = 31 * result + ("@" + this.dstMac + "@" + this.ethType + "@" + this.vlanId
                + "@" + this.srcIp + "@" + this.dstIp + "@" + this.ipProto + "@" + this.srcPort + "@" + this.dstPort
                + "@" + this.icmpType+ "@" + this.icmpCode).hashCode();

        return result;
    }

    public long getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(long createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @Override
    public boolean equals(Object obj) {
        OFFlow flow = (OFFlow) obj;
        return  this.srcMac.equals(flow.getSrcMac()) &&
                this.dstMac.equals(flow.getDstMac()) &&
                this.ethType.equals(flow.getEthType()) &&
                this.vlanId.equals(flow.getVlanId()) &&
                this.srcIp.equals(flow.getSrcIp()) &&
                this.dstIp.equals(flow.getDstIp()) &&
                this.ipProto.equals(flow.getIpProto()) &&
                this.srcPort.equals(flow.getSrcPort()) &&
                this.icmpType.equals(flow.getIcmpType()) &&
                this.icmpCode.equals(flow.getIcmpCode()) &&
                this.dstPort.equals(flow.getDstPort());

    }

    public long getVolumeTransmitted() {
        return volumeTransmitted;
    }

    public void setVolumeTransmitted(long volumeTransmitted) {
        this.volumeTransmitted = volumeTransmitted;
    }

    public long getIdleTimeOut() {
        return idleTimeOut;
    }

    public void setIdleTimeOut(long idleTimeOut) {
        this.idleTimeOut = idleTimeOut;
    }

    public long getLastPacketTransmittedTime() {
        return lastPacketTransmittedTime;
    }

    public void setLastPacketTransmittedTime(long lastPacketTransmittedTime) {
        this.lastPacketTransmittedTime = lastPacketTransmittedTime;
    }

    public String getIcmpType() {
        return icmpType;
    }

    public void setIcmpType(String icmpType) {
        this.icmpType = icmpType;
    }

    public String getIcmpCode() {
        return icmpCode;
    }

    public void setIcmpCode(String icmpCode) {
        this.icmpCode = icmpCode;
    }

    public String getFlowHeaderString() {
        return "srcMac,dstMac,ethType,vlanId,srcIp,dstIp,ipProto,srcPort,dstPort,priority,icmpType,icmpCode,volumeTransmitted,packetCount";
    }

    public String getFlowString() {
        return srcMac + "," + dstMac + "," + ethType + "," + vlanId + "," + srcIp + "," + dstIp + ","
                + ipProto + "," + srcPort + "," + dstPort + "," + priority + "," + icmpType + "," + icmpCode
                + "," + volumeTransmitted + "," + packetCount;
    }

    public String getFlowHeaderWithoutFlowStat() {
        return "srcMac,dstMac,ethType,vlanId,srcIp,dstIp,ipProto,srcPort,dstPort,priority,icmpType,icmpCode";
    }

    public String getFlowStringWithoutFlowStat() {
        return srcMac + "," + dstMac + "," + ethType + "," + vlanId + "," + srcIp + "," + dstIp + ","
                + ipProto + "," + srcPort + "," + dstPort + "," + priority + "," + icmpType + "," + icmpCode ;
    }

}
