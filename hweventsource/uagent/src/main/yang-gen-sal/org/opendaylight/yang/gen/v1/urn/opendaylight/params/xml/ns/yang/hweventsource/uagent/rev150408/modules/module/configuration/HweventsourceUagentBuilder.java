package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.hweventsource.uagent.Broker;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.ArrayList;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.hweventsource.uagent.DomBroker;
import com.google.common.collect.Range;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.math.BigInteger;
import java.util.List;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent
 *
 */
public class HweventsourceUagentBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent> {

    private Broker _broker;
    private DomBroker _domBroker;
    private java.lang.String _outputFileName;
    private static void check_outputFileNameLength(final String value) {
        final int length = value.length();
        if (length >= 1 && length <= 1024) {
            return;
        }
        throw new IllegalArgumentException(String.format("Invalid length: %s, expected: [[1‥1024]].", value));
    }

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent>> augmentation = Collections.emptyMap();

    public HweventsourceUagentBuilder() {
    }

    public HweventsourceUagentBuilder(HweventsourceUagent base) {
        this._broker = base.getBroker();
        this._domBroker = base.getDomBroker();
        this._outputFileName = base.getOutputFileName();
        if (base instanceof HweventsourceUagentImpl) {
            HweventsourceUagentImpl impl = (HweventsourceUagentImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public Broker getBroker() {
        return _broker;
    }
    
    public DomBroker getDomBroker() {
        return _domBroker;
    }
    
    public java.lang.String getOutputFileName() {
        return _outputFileName;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public HweventsourceUagentBuilder setBroker(Broker value) {
        this._broker = value;
        return this;
    }
    
    public HweventsourceUagentBuilder setDomBroker(DomBroker value) {
        this._domBroker = value;
        return this;
    }
    
    public HweventsourceUagentBuilder setOutputFileName(java.lang.String value) {
        if (value != null) {
            check_outputFileNameLength(value);
        }
        this._outputFileName = value;
        return this;
    }
    /**
     * @deprecated This method is slated for removal in a future release. See BUG-1485 for details.
     */
    @Deprecated
    public static List<Range<BigInteger>> _outputFileName_length() {
        List<Range<BigInteger>> ret = new ArrayList<>(1);
        ret.add(Range.closed(BigInteger.ONE, BigInteger.valueOf(1024L)));
        return ret;
    }
    
    public HweventsourceUagentBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public HweventsourceUagentBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public HweventsourceUagent build() {
        return new HweventsourceUagentImpl(this);
    }

    private static final class HweventsourceUagentImpl implements HweventsourceUagent {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent.class;
        }

        private final Broker _broker;
        private final DomBroker _domBroker;
        private final java.lang.String _outputFileName;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent>> augmentation = Collections.emptyMap();

        private HweventsourceUagentImpl(HweventsourceUagentBuilder base) {
            this._broker = base.getBroker();
            this._domBroker = base.getDomBroker();
            this._outputFileName = base.getOutputFileName();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public Broker getBroker() {
            return _broker;
        }
        
        @Override
        public DomBroker getDomBroker() {
            return _domBroker;
        }
        
        @Override
        public java.lang.String getOutputFileName() {
            return _outputFileName;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + ((_broker == null) ? 0 : _broker.hashCode());
            result = prime * result + ((_domBroker == null) ? 0 : _domBroker.hashCode());
            result = prime * result + ((_outputFileName == null) ? 0 : _outputFileName.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent)obj;
            if (_broker == null) {
                if (other.getBroker() != null) {
                    return false;
                }
            } else if(!_broker.equals(other.getBroker())) {
                return false;
            }
            if (_domBroker == null) {
                if (other.getDomBroker() != null) {
                    return false;
                }
            } else if(!_domBroker.equals(other.getDomBroker())) {
                return false;
            }
            if (_outputFileName == null) {
                if (other.getOutputFileName() != null) {
                    return false;
                }
            } else if(!_outputFileName.equals(other.getOutputFileName())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                HweventsourceUagentImpl otherImpl = (HweventsourceUagentImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("HweventsourceUagent [");
            boolean first = true;
        
            if (_broker != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_broker=");
                builder.append(_broker);
             }
            if (_domBroker != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_domBroker=");
                builder.append(_domBroker);
             }
            if (_outputFileName != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_outputFileName=");
                builder.append(_outputFileName);
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
