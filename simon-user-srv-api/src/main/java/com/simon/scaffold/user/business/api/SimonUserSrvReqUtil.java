package com.simon.scaffold.user.business.api;

import com.simon.scaffold.user.business.request.base.AdapterBaseRequest;
import com.simon.scaffold.user.business.request.base.SimonUserSrvRequest;
import com.simon.scaffold.user.business.response.base.AdapterBaseResponse;
import com.simon.scaffold.user.business.response.base.SimonUserSrvResponse;
import com.simon.scaffold.user.service.union.SimonUserSrvService;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.UUID;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 15:59
 * @description: RPC 请求工具类
 */
public class SimonUserSrvReqUtil<K extends AdapterBaseRequest, V extends AdapterBaseResponse> {

    private String api;
    private String version;
    private String ip;
    private String transId;
    private SimonUserSrvService<K, V> simonUserSrvService;

    public SimonUserSrvReqUtil() {
    }

    public SimonUserSrvReqUtil(String api, SimonUserSrvService<K, V> simonUserSrvService) {
        this.api = api;
        this.transId = UUID.randomUUID().toString();
        this.version = "1.0";
        this.ip = getIpAddresses();
        this.simonUserSrvService = simonUserSrvService;
    }

    public SimonUserSrvReqUtil(String api, String transId, SimonUserSrvService<K, V> simonUserSrvService) {
        this.api = api;
        this.transId = transId;
        this.ip = getIpAddresses();
        this.version = "1.0";
        this.simonUserSrvService = simonUserSrvService;
    }

    public SimonUserSrvReqUtil(String api, String transId, String ip, SimonUserSrvService<K, V> simonUserSrvService) {
        this.api = api;
        this.transId = transId;
        this.ip = ip;
        this.version = "1.0";
        this.simonUserSrvService = simonUserSrvService;
    }

    public SimonUserSrvReqUtil(String api, String transId, String ip, String version, SimonUserSrvService<K, V> simonUserSrvService) {
        this.api = api;
        this.transId = transId;
        this.ip = ip;
        this.version = version;
        this.simonUserSrvService = simonUserSrvService;
    }

    public SimonUserSrvResponse<V> rpc(K busiRequest) {

        SimonUserSrvRequest<K> simonUserSrvRequest = new SimonUserSrvRequest<>();
        simonUserSrvRequest.setTransId(null == transId ? UUID.randomUUID().toString() : transId);
        simonUserSrvRequest.setRequestIp(null == ip ? getIpAddresses() : ip);
        simonUserSrvRequest.setVersion(null == version ? "1.0" : version);
        simonUserSrvRequest.setTimestamp(System.currentTimeMillis());
        simonUserSrvRequest.setMethod(api);
        simonUserSrvRequest.setBusiRequest(busiRequest);
        return simonUserSrvService.dispatcher(simonUserSrvRequest);
    }

    private static String getIpAddresses() {

        String ip = "unknown";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            InetAddress localAddress = null;
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress address = inetAddresses.nextElement();
                    if (!address.isLoopbackAddress() && !(address instanceof Inet6Address)) {
                        return address.getHostAddress();
                    } else if (!address.isLoopbackAddress()) {
                        localAddress = address;
                    }
                }
            }

            assert localAddress != null;
            ip = localAddress.getHostAddress();
        } catch (Exception ignored) {
        }
        return ip;
    }
}
