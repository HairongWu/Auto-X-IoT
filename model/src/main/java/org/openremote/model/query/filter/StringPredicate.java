/*
 * Copyright 2017, OpenRemote Inc.
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
package org.openremote.model.query.filter;

import org.openremote.model.query.BaseAssetQuery;
import org.openremote.model.value.ObjectValue;
import org.openremote.model.value.Values;

import java.util.Locale;
import java.util.function.Predicate;

public class StringPredicate implements ValuePredicate {

    public static final String name = "string";
    public BaseAssetQuery.Match match = BaseAssetQuery.Match.EXACT;
    public boolean caseSensitive = true;
    public String value;
    public boolean negate;

    public StringPredicate() {
    }

    public StringPredicate(String value) {
        this.value = value;
    }

    public StringPredicate(BaseAssetQuery.Match match, String value) {
        this.match = match;
        this.value = value;
    }

    public StringPredicate(BaseAssetQuery.Match match, boolean caseSensitive, String value) {
        this.match = match;
        this.caseSensitive = caseSensitive;
        this.value = value;
    }

    public static StringPredicate fromObjectValue(ObjectValue objectValue) {
        StringPredicate stringPredicate = new StringPredicate();
        objectValue.getString("match").ifPresent(match -> {
            stringPredicate.match = BaseAssetQuery.Match.valueOf(match);
        });
        objectValue.getBoolean("caseSensitive").ifPresent(caseSensitive -> {
            stringPredicate.caseSensitive = caseSensitive;
        });
        objectValue.getBoolean("negate").ifPresent(negate -> {
            stringPredicate.negate = negate;
        });
        objectValue.getString("value").ifPresent(value -> {
            stringPredicate.value = value;
        });
        return stringPredicate;
    }

    public static Predicate<String> asPredicate(StringPredicate predicate) {
        return string -> {
            if (string == null && predicate.value == null)
                return !predicate.negate;
            if (string == null)
                return predicate.negate;
            if (predicate.value == null)
                return predicate.negate;

            String shouldMatch = predicate.caseSensitive ? predicate.value : predicate.value.toUpperCase(Locale.ROOT);
            String have = predicate.caseSensitive ? string : string.toUpperCase(Locale.ROOT);

            switch (predicate.match) {
                case BEGIN:
                    return predicate.negate != have.startsWith(shouldMatch);
                case END:
                    return predicate.negate != have.endsWith(shouldMatch);
                case CONTAINS:
                    return predicate.negate != have.contains(shouldMatch);
            }
            return predicate.negate != have.equals(shouldMatch);
        };
    }

    public StringPredicate match(BaseAssetQuery.Match match) {
        this.match = match;
        return this;
    }

    public StringPredicate caseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
        return this;
    }

    public StringPredicate value(String value) {
        this.value = value;
        return this;
    }

    public StringPredicate negate(boolean negate) {
        this.negate = negate;
        return this;
    }

    public String prepareValue() {
        String s = match.prepare(this.value);
        if (!caseSensitive)
            s = s.toUpperCase(Locale.ROOT);
        return s;
    }

    public ObjectValue toModelValue() {
        ObjectValue objectValue = Values.createObject();
        objectValue.put("predicateType", name);
        if (match != null) {
            objectValue.put("match", Values.create(match.toString()));
        }
        objectValue.put("caseSensitive", Values.create(caseSensitive));
        objectValue.put("negate", Values.create(negate));
        if (value != null) {
            objectValue.put("value", Values.create(value));
        }
        return objectValue;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
            "match=" + match +
            ", caseSensitive=" + caseSensitive +
            ", negate=" + negate +
            ", value='" + value + '\'' +
            '}';
    }
}
