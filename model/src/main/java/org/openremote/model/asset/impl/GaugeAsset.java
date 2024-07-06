/*
 * Copyright 2020, OpenRemote Inc.
 *
 * See the CONTRIBUTORS.txt file in the distribution for a
 * full listing of individual contributors.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.openremote.model.asset.impl;

import org.openremote.model.asset.Asset;
import org.openremote.model.asset.AssetDescriptor;
import org.openremote.model.attribute.MetaItem;
import org.openremote.model.value.AttributeDescriptor;
import org.openremote.model.value.MetaItemType;
import org.openremote.model.value.ValueType;

import jakarta.persistence.Entity;
import java.util.Optional;

import static org.openremote.model.Constants.UNITS_GALLON;

@Entity
public class GaugeAsset extends Asset<GaugeAsset> {
    public static final AttributeDescriptor<Double> READING = new AttributeDescriptor<>("reading", ValueType.NUMBER,
            new MetaItem<>(MetaItemType.READ_ONLY)
    );
    public static final AttributeDescriptor<String> GAUGE_TYPE = new AttributeDescriptor<>("gaugeType", ValueType.TEXT);
    public static final AttributeDescriptor<Integer> POINTER_NUMBER = new AttributeDescriptor<>("pointerNumber", ValueType.INTEGER);

    public static final AssetDescriptor<GaugeAsset> DESCRIPTOR = new AssetDescriptor<>("circle", null, GaugeAsset.class);

    /**
     * For use by hydrators (i.e. JPA/Jackson)
     */
    protected GaugeAsset() {
    }

    public GaugeAsset(String name) {
        super(name);
    }

    public Optional<String> getGaugeType() {
		return getAttributes().getValue(GAUGE_TYPE);
	}

    public Optional<Integer> getPointerNumber() {
        return getAttributes().getValue(POINTER_NUMBER);
    }

    public Optional<Double> getReading() {
        return getAttributes().getValue(READING);
    }
}
