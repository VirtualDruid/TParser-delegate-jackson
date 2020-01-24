import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import core.JsonDelegate;

import java.math.BigDecimal;
import java.math.BigInteger;

@SuppressWarnings("unused")
public class JacksonDelegate implements JsonDelegate<ObjectNode, ArrayNode> {
    private ObjectMapper objectMapper;

    public JacksonDelegate(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public ObjectNode createObjectNode() {
        return objectMapper.createObjectNode();
    }

    @Override
    public ArrayNode createArrayNode() {
        return objectMapper.createArrayNode();
    }

    @Override
    public void putValue(ObjectNode objectNode, String key, Object value) {
        if (value instanceof String) {
            objectNode.put(key, (String) value);
            return;
        }
        if (value instanceof Integer) {
            objectNode.put(key, (Integer) value);
            return;
        }
        if (value instanceof Float) {
            objectNode.put(key, (Float) value);
            return;
        }
        if (value instanceof Double) {
            objectNode.put(key, (Double) value);
            return;
        }
        if (value instanceof Boolean) {
            objectNode.put(key, (Boolean) value);
            return;
        }
        if (value instanceof Long) {
            objectNode.put(key, (Long) value);
            return;
        }
        if (value instanceof Short) {
            objectNode.put(key, (Short) value);
            return;
        }
        if (value instanceof Byte) {
            objectNode.put(key, (Byte) value);
            return;
        }
        if (value instanceof byte[]) {
            objectNode.put(key, (byte[]) value);
            return;
        }
        if (value instanceof BigInteger) {
            objectNode.put(key, (BigInteger) value);
            return;
        }
        if (value instanceof BigDecimal) {
            objectNode.put(key, (BigDecimal) value);
            return;
        }
        throw new IllegalArgumentException("unsupported json value type");
    }

    @Override
    public void putNull(ObjectNode objectNode, String key) {
        objectNode.putNull(key);
    }

    @Override
    public void putObjectNode(ObjectNode objectNode, String key, ObjectNode value) {
        objectNode.set(key, value);
    }

    @Override
    public void putArrayNode(ObjectNode objectNode, String key, ArrayNode value) {
        objectNode.set(key, value);
    }

    @Override
    public void add(ArrayNode arrayNode, ObjectNode itemToAdd) {
        arrayNode.add(itemToAdd);
    }

    public static JsonDelegate<ObjectNode, ArrayNode> create(ObjectMapper configured) {
        return new JacksonDelegate(configured);
    }
}
