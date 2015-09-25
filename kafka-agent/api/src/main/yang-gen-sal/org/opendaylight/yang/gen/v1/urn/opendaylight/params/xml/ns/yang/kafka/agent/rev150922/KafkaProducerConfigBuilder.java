package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig.MessageSerialization;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig.ProducerType;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig.CompressionCodec;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig
 *
 */
public class KafkaProducerConfigBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig> {

    private java.lang.String _avroSchema;
    private CompressionCodec _compressionCodec;
    private java.lang.String _defaultHostIp;
    private java.lang.String _dpMessageHostIpXpath;
    private java.lang.String _dpMessageSourceXpath;
    private java.lang.String _dpTimestampXpath;
    private MessageSerialization _messageSerialization;
    private java.lang.String _metadataBrokerList;
    private ProducerType _producerType;
    private java.lang.String _topic;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig>> augmentation = Collections.emptyMap();

    public KafkaProducerConfigBuilder() {
    }

    public KafkaProducerConfigBuilder(KafkaProducerConfig base) {
        this._avroSchema = base.getAvroSchema();
        this._compressionCodec = base.getCompressionCodec();
        this._defaultHostIp = base.getDefaultHostIp();
        this._dpMessageHostIpXpath = base.getDpMessageHostIpXpath();
        this._dpMessageSourceXpath = base.getDpMessageSourceXpath();
        this._dpTimestampXpath = base.getDpTimestampXpath();
        this._messageSerialization = base.getMessageSerialization();
        this._metadataBrokerList = base.getMetadataBrokerList();
        this._producerType = base.getProducerType();
        this._topic = base.getTopic();
        if (base instanceof KafkaProducerConfigImpl) {
            KafkaProducerConfigImpl impl = (KafkaProducerConfigImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public java.lang.String getAvroSchema() {
        return _avroSchema;
    }
    
    public CompressionCodec getCompressionCodec() {
        return _compressionCodec;
    }
    
    public java.lang.String getDefaultHostIp() {
        return _defaultHostIp;
    }
    
    public java.lang.String getDpMessageHostIpXpath() {
        return _dpMessageHostIpXpath;
    }
    
    public java.lang.String getDpMessageSourceXpath() {
        return _dpMessageSourceXpath;
    }
    
    public java.lang.String getDpTimestampXpath() {
        return _dpTimestampXpath;
    }
    
    public MessageSerialization getMessageSerialization() {
        return _messageSerialization;
    }
    
    public java.lang.String getMetadataBrokerList() {
        return _metadataBrokerList;
    }
    
    public ProducerType getProducerType() {
        return _producerType;
    }
    
    public java.lang.String getTopic() {
        return _topic;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public KafkaProducerConfigBuilder setAvroSchema(java.lang.String value) {
        this._avroSchema = value;
        return this;
    }
    
    public KafkaProducerConfigBuilder setCompressionCodec(CompressionCodec value) {
        this._compressionCodec = value;
        return this;
    }
    
    public KafkaProducerConfigBuilder setDefaultHostIp(java.lang.String value) {
        this._defaultHostIp = value;
        return this;
    }
    
    public KafkaProducerConfigBuilder setDpMessageHostIpXpath(java.lang.String value) {
        this._dpMessageHostIpXpath = value;
        return this;
    }
    
    public KafkaProducerConfigBuilder setDpMessageSourceXpath(java.lang.String value) {
        this._dpMessageSourceXpath = value;
        return this;
    }
    
    public KafkaProducerConfigBuilder setDpTimestampXpath(java.lang.String value) {
        this._dpTimestampXpath = value;
        return this;
    }
    
    public KafkaProducerConfigBuilder setMessageSerialization(MessageSerialization value) {
        this._messageSerialization = value;
        return this;
    }
    
    public KafkaProducerConfigBuilder setMetadataBrokerList(java.lang.String value) {
        this._metadataBrokerList = value;
        return this;
    }
    
    public KafkaProducerConfigBuilder setProducerType(ProducerType value) {
        this._producerType = value;
        return this;
    }
    
    public KafkaProducerConfigBuilder setTopic(java.lang.String value) {
        this._topic = value;
        return this;
    }
    
    public KafkaProducerConfigBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public KafkaProducerConfigBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public KafkaProducerConfig build() {
        return new KafkaProducerConfigImpl(this);
    }

    private static final class KafkaProducerConfigImpl implements KafkaProducerConfig {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig.class;
        }

        private final java.lang.String _avroSchema;
        private final CompressionCodec _compressionCodec;
        private final java.lang.String _defaultHostIp;
        private final java.lang.String _dpMessageHostIpXpath;
        private final java.lang.String _dpMessageSourceXpath;
        private final java.lang.String _dpTimestampXpath;
        private final MessageSerialization _messageSerialization;
        private final java.lang.String _metadataBrokerList;
        private final ProducerType _producerType;
        private final java.lang.String _topic;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig>> augmentation = Collections.emptyMap();

        private KafkaProducerConfigImpl(KafkaProducerConfigBuilder base) {
            this._avroSchema = base.getAvroSchema();
            this._compressionCodec = base.getCompressionCodec();
            this._defaultHostIp = base.getDefaultHostIp();
            this._dpMessageHostIpXpath = base.getDpMessageHostIpXpath();
            this._dpMessageSourceXpath = base.getDpMessageSourceXpath();
            this._dpTimestampXpath = base.getDpTimestampXpath();
            this._messageSerialization = base.getMessageSerialization();
            this._metadataBrokerList = base.getMetadataBrokerList();
            this._producerType = base.getProducerType();
            this._topic = base.getTopic();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.String getAvroSchema() {
            return _avroSchema;
        }
        
        @Override
        public CompressionCodec getCompressionCodec() {
            return _compressionCodec;
        }
        
        @Override
        public java.lang.String getDefaultHostIp() {
            return _defaultHostIp;
        }
        
        @Override
        public java.lang.String getDpMessageHostIpXpath() {
            return _dpMessageHostIpXpath;
        }
        
        @Override
        public java.lang.String getDpMessageSourceXpath() {
            return _dpMessageSourceXpath;
        }
        
        @Override
        public java.lang.String getDpTimestampXpath() {
            return _dpTimestampXpath;
        }
        
        @Override
        public MessageSerialization getMessageSerialization() {
            return _messageSerialization;
        }
        
        @Override
        public java.lang.String getMetadataBrokerList() {
            return _metadataBrokerList;
        }
        
        @Override
        public ProducerType getProducerType() {
            return _producerType;
        }
        
        @Override
        public java.lang.String getTopic() {
            return _topic;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + ((_avroSchema == null) ? 0 : _avroSchema.hashCode());
            result = prime * result + ((_compressionCodec == null) ? 0 : _compressionCodec.hashCode());
            result = prime * result + ((_defaultHostIp == null) ? 0 : _defaultHostIp.hashCode());
            result = prime * result + ((_dpMessageHostIpXpath == null) ? 0 : _dpMessageHostIpXpath.hashCode());
            result = prime * result + ((_dpMessageSourceXpath == null) ? 0 : _dpMessageSourceXpath.hashCode());
            result = prime * result + ((_dpTimestampXpath == null) ? 0 : _dpTimestampXpath.hashCode());
            result = prime * result + ((_messageSerialization == null) ? 0 : _messageSerialization.hashCode());
            result = prime * result + ((_metadataBrokerList == null) ? 0 : _metadataBrokerList.hashCode());
            result = prime * result + ((_producerType == null) ? 0 : _producerType.hashCode());
            result = prime * result + ((_topic == null) ? 0 : _topic.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig)obj;
            if (_avroSchema == null) {
                if (other.getAvroSchema() != null) {
                    return false;
                }
            } else if(!_avroSchema.equals(other.getAvroSchema())) {
                return false;
            }
            if (_compressionCodec == null) {
                if (other.getCompressionCodec() != null) {
                    return false;
                }
            } else if(!_compressionCodec.equals(other.getCompressionCodec())) {
                return false;
            }
            if (_defaultHostIp == null) {
                if (other.getDefaultHostIp() != null) {
                    return false;
                }
            } else if(!_defaultHostIp.equals(other.getDefaultHostIp())) {
                return false;
            }
            if (_dpMessageHostIpXpath == null) {
                if (other.getDpMessageHostIpXpath() != null) {
                    return false;
                }
            } else if(!_dpMessageHostIpXpath.equals(other.getDpMessageHostIpXpath())) {
                return false;
            }
            if (_dpMessageSourceXpath == null) {
                if (other.getDpMessageSourceXpath() != null) {
                    return false;
                }
            } else if(!_dpMessageSourceXpath.equals(other.getDpMessageSourceXpath())) {
                return false;
            }
            if (_dpTimestampXpath == null) {
                if (other.getDpTimestampXpath() != null) {
                    return false;
                }
            } else if(!_dpTimestampXpath.equals(other.getDpTimestampXpath())) {
                return false;
            }
            if (_messageSerialization == null) {
                if (other.getMessageSerialization() != null) {
                    return false;
                }
            } else if(!_messageSerialization.equals(other.getMessageSerialization())) {
                return false;
            }
            if (_metadataBrokerList == null) {
                if (other.getMetadataBrokerList() != null) {
                    return false;
                }
            } else if(!_metadataBrokerList.equals(other.getMetadataBrokerList())) {
                return false;
            }
            if (_producerType == null) {
                if (other.getProducerType() != null) {
                    return false;
                }
            } else if(!_producerType.equals(other.getProducerType())) {
                return false;
            }
            if (_topic == null) {
                if (other.getTopic() != null) {
                    return false;
                }
            } else if(!_topic.equals(other.getTopic())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                KafkaProducerConfigImpl otherImpl = (KafkaProducerConfigImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("KafkaProducerConfig [");
            boolean first = true;
        
            if (_avroSchema != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_avroSchema=");
                builder.append(_avroSchema);
             }
            if (_compressionCodec != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_compressionCodec=");
                builder.append(_compressionCodec);
             }
            if (_defaultHostIp != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_defaultHostIp=");
                builder.append(_defaultHostIp);
             }
            if (_dpMessageHostIpXpath != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dpMessageHostIpXpath=");
                builder.append(_dpMessageHostIpXpath);
             }
            if (_dpMessageSourceXpath != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dpMessageSourceXpath=");
                builder.append(_dpMessageSourceXpath);
             }
            if (_dpTimestampXpath != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dpTimestampXpath=");
                builder.append(_dpTimestampXpath);
             }
            if (_messageSerialization != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_messageSerialization=");
                builder.append(_messageSerialization);
             }
            if (_metadataBrokerList != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_metadataBrokerList=");
                builder.append(_metadataBrokerList);
             }
            if (_producerType != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_producerType=");
                builder.append(_producerType);
             }
            if (_topic != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_topic=");
                builder.append(_topic);
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
