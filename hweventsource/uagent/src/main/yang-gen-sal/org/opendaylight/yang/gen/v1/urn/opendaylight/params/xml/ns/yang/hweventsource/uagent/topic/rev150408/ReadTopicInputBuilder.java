package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.ArrayList;
import java.math.BigInteger;
import java.util.List;
import java.util.Collections;
import com.google.common.collect.Range;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput
 *
 */
public class ReadTopicInputBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput> {

    private TopicId _topicId;
    private static void check_topicIdLength(final String value) {
        final int length = value.length();
        if (length >= 1) {
            return;
        }
        throw new IllegalArgumentException(String.format("Invalid length: %s, expected: [[1‥2147483647]].", value));
    }

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput>> augmentation = Collections.emptyMap();

    public ReadTopicInputBuilder() {
    }

    public ReadTopicInputBuilder(ReadTopicInput base) {
        this._topicId = base.getTopicId();
        if (base instanceof ReadTopicInputImpl) {
            ReadTopicInputImpl impl = (ReadTopicInputImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public TopicId getTopicId() {
        return _topicId;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public ReadTopicInputBuilder setTopicId(TopicId value) {
        if (value != null) {
            check_topicIdLength(value.getValue());
        }
        this._topicId = value;
        return this;
    }
    /**
     * @deprecated This method is slated for removal in a future release. See BUG-1485 for details.
     */
    @Deprecated
    public static List<Range<BigInteger>> _topicId_length() {
        List<Range<BigInteger>> ret = new ArrayList<>(1);
        ret.add(Range.closed(BigInteger.ONE, BigInteger.valueOf(2147483647L)));
        return ret;
    }
    
    public ReadTopicInputBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public ReadTopicInputBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public ReadTopicInput build() {
        return new ReadTopicInputImpl(this);
    }

    private static final class ReadTopicInputImpl implements ReadTopicInput {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput.class;
        }

        private final TopicId _topicId;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput>> augmentation = Collections.emptyMap();

        private ReadTopicInputImpl(ReadTopicInputBuilder base) {
            this._topicId = base.getTopicId();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public TopicId getTopicId() {
            return _topicId;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        private int hash = 0;
        private volatile boolean hashValid = false;
        
        @Override
        public int hashCode() {
            if (hashValid) {
                return hash;
            }
        
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_topicId == null) ? 0 : _topicId.hashCode());
            result = prime * result + ((augmentation == null) ? 0 : augmentation.hashCode());
        
            hash = result;
            hashValid = true;
            return result;
        }

        @Override
        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DataObject)) {
                return false;
            }
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput)obj;
            if (_topicId == null) {
                if (other.getTopicId() != null) {
                    return false;
                }
            } else if(!_topicId.equals(other.getTopicId())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                ReadTopicInputImpl otherImpl = (ReadTopicInputImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput>> e : augmentation.entrySet()) {
                    if (!e.getValue().equals(other.getAugmentation(e.getKey()))) {
                        return false;
                    }
                }
                // .. and give the other one the chance to do the same
                if (!obj.equals(this)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public java.lang.String toString() {
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("ReadTopicInput [");
            boolean first = true;
        
            if (_topicId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_topicId=");
                builder.append(_topicId);
             }
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("augmentation=");
            builder.append(augmentation.values());
            return builder.append(']').toString();
        }
    }

}
