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
import org.openremote.model.value.*;

import jakarta.persistence.Entity;
import java.util.Optional;

import static org.openremote.model.Constants.UNITS_KNOT;
import static org.openremote.model.Constants.UNITS_METRE;

@Entity
public class DroneAsset extends Asset<DroneAsset> {

    public static final AttributeDescriptor<String> DRONE_TYPE = new AttributeDescriptor<>("droneType", ValueType.TEXT);

    public static final AssetDescriptor<DroneAsset> DESCRIPTOR = new AssetDescriptor<>("circle", "000080", DroneAsset.class);

    /**
     * For use by hydrators (i.e. JPA/Jackson)
     */
    protected DroneAsset() {
    }

    public DroneAsset(String name) {
        super(name);
    }

    public Optional<String> getDroneType() {
        return getAttributes().getValue(DRONE_TYPE);
    }

    public DroneAsset setDroneType(String value) {
        getAttributes().getOrCreate(DRONE_TYPE).setValue(value);
        return this;
    }
}
