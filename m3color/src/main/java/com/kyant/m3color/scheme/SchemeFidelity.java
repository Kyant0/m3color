/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kyant.m3color.scheme;

import static com.kyant.m3color.dynamiccolor.DynamicScheme.Platform.PHONE;

import com.kyant.m3color.dynamiccolor.ColorSpec.SpecVersion;
import com.kyant.m3color.dynamiccolor.ColorSpecs;
import com.kyant.m3color.dynamiccolor.DynamicScheme;
import com.kyant.m3color.dynamiccolor.Variant;
import com.kyant.m3color.hct.Hct;

/**
 * A scheme that places the source color in Scheme.primaryContainer.
 *
 * <p>Primary Container is the source color, adjusted for color relativity. It maintains constant
 * appearance in light mode and dark mode. This adds ~5 tone in light mode, and subtracts ~5 tone in
 * dark mode.
 *
 * <p>Tertiary Container is the complement to the source color, using TemperatureCache. It also
 * maintains constant appearance.
 */
public class SchemeFidelity extends DynamicScheme {
    public SchemeFidelity(Hct sourceColorHct, boolean isDark, double contrastLevel) {
        super(
                sourceColorHct,
                Variant.FIDELITY,
                isDark,
                contrastLevel,
                ColorSpecs.get(SpecVersion.SPEC_2021)
                        .getPrimaryPalette(Variant.FIDELITY, sourceColorHct, isDark, PHONE, contrastLevel),
                ColorSpecs.get(SpecVersion.SPEC_2021)
                        .getSecondaryPalette(Variant.FIDELITY, sourceColorHct, isDark, PHONE, contrastLevel),
                ColorSpecs.get(SpecVersion.SPEC_2021)
                        .getTertiaryPalette(Variant.FIDELITY, sourceColorHct, isDark, PHONE, contrastLevel),
                ColorSpecs.get(SpecVersion.SPEC_2021)
                        .getNeutralPalette(Variant.FIDELITY, sourceColorHct, isDark, PHONE, contrastLevel),
                ColorSpecs.get(SpecVersion.SPEC_2021)
                        .getNeutralVariantPalette(
                                Variant.FIDELITY, sourceColorHct, isDark, PHONE, contrastLevel),
                ColorSpecs.get(SpecVersion.SPEC_2021)
                        .getErrorPalette(Variant.FIDELITY, sourceColorHct, isDark, PHONE, contrastLevel));
    }
}
