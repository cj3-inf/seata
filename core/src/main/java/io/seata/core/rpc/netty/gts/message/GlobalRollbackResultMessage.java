package io.seata.core.rpc.netty.gts.message;

import java.nio.ByteBuffer;

public class GlobalRollbackResultMessage extends AbstractResultMessage {
    private static final long serialVersionUID = -2141370444891199652L;
    private long tranId;

    public GlobalRollbackResultMessage() {
    }

    public long getTranId() {
        return this.tranId;
    }

    public void setTranId(long tranId) {
        this.tranId = tranId;
    }

    public String toString() {
        return "GlobalRollbackResultMessage tranId:" + this.tranId + ",result:" + this.result + ",msg:" + this.getMsg();
    }

    public short getTypeCode() {
        return 10;
    }

    public byte[] encode() {
        super.encode();
        this.byteBuffer.flip();
        byte[] content = new byte[this.byteBuffer.limit()];
        this.byteBuffer.get(content);
        return content;
    }

    public void decode(ByteBuffer byteBuffer) {
        super.decode(byteBuffer);
    }
}
