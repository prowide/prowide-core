/*
* Copyright 2006-2024 Prowide
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.prowidesoftware.swift.model.mt;

import com.prowidesoftware.Generated;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
* Enumeration representing all possible sequence paths for each MT (Message Type) schema.
* Each constant in this enumeration corresponds to a specific MT schema, identified by its
* sequence paths as a comma-separated string (CSV) for SRU 2024.
*
* <p>For example, the MT508 message type may have sequence paths such as "A", "A/A1", "B", "B/B1", and "C",
* which would be represented as the CSV string "A,A/A1,B,B/B1,C".
* Note that internal loops not clearly identified and named in the standard as a sequence, are excluded.
*
* <p>For example, the MT801 message contains the "Loop1" and "Loop2" sequences, and this are not included in the sequence paths.
*
* @since 9.5.3
*/
@Generated
public enum MtSequenceEnum {

    MT101("A,B"),
    MT102("A,B,C"),
    MT102_STP("A,B,C"),
    MT104("A,B,C"),
    MT107("A,B,C"),
    MT202COV("A,B"),
    MT204("A,B"),
    MT205COV("A,B"),
    MT300("A,B,B/B1,B/B2,C,D,D/D1,E,E/E1,E/E1/E1a,E/E1/E1a/E1a1,F"),
    MT304("A,B,B/B1,B/B2,C,C/C1,C/C1/C1a,D,E"),
    MT305("A,B,B/B1,B/B1/B1a,B/B1/B1a/B1a1"),
    MT306("A,B,B/B1,B/B2,C,D,E,F,F/F1,G,H,I,J,J/J1,J/J2,K,L,M,M/M1,M/M1/M1a,M/M1/M1a/M1a1"),
    MT320("A,B,C,D,E,F,G,H,I"),
    MT321("A,A/A1,B,B/B1,B/B2,B/B3,C,C/C1"),
    MT330("A,B,C,D,E,F,G,H"),
    MT340("A,B,B/B1,B/B2,C,D,E,F,G,G/G1,G/G1/G1a,G/G1/G1a/G1a1"),
    MT341("A,B,B/B1,C,D,D/D1,D/D1/D1a,D/D1/D1a/D1a1"),
    MT350("A,B,C,D,D/D1,D/D2"),
    MT360("A,B,B/B1,C,C/C1,C/C2,C/C3,D,E,E/E1,F,F/F1,F/F2,F/F3,G,H,L,M,N,O,O/O1,O/O1/O1a,O/O1/O1a/O1a1"),
    MT361("A,B,B/B1,C,C/C1,C/C2,C/C3,D,E,E/E1,F,F/F1,F/F2,F/F3,G,H,I,J,K,L,M,N,O,P,P/P1,P/P1/P1a,P/P1/P1a/P1a1"),
    MT362("A,B,C,D,E"),
    MT364("A,B,E,L,M"),
    MT365("A,B,E,J,K,L,M"),
    MT370("A,A/A1,A/A2,B,B/B1"),
    MT380("A,A/A1,B,B/B1,B/B2,C"),
    MT381("A,A/A1,B,B/B1,B/B2,C"),
    MT416("A,B"),
    MT430("A,B"),
    MT500("A,A/A1,B,B/B1,B/B2,C,C/C1,C/C2,D,E"),
    MT501("A,A/A1,B,B/B1,B/B2,C,C/C1,C/C2,D,E"),
    MT502("A,A/A1,B,B/B1,B/B2,B/B3,C,C/C1,C/C2,C/C3,D,E"),
    MT503("A,A/A1,A/A2,B,B/B1,C,C/C1,C/C2,C/C3,D"),
    MT504("A,A/A1,A/A2,B,B/B1,C,C/C1,C/C1/C1a,C/C1/C1a/C1a1,C/C2,C/C2/C2a,C/C2/C2a/C2a1,C/C3,D,D/D1,E,E/E1,F"),
    MT505("A,A/A1,A/A2,B,B/B1,B/B1/B1a,B/B1/B1a/B1a1,B/B2,B/B2/B2a,B/B2/B2a/B2a1,B/B3,C,C/C1,D,D/D1,E"),
    MT506("A,A/A1,A/A2,B,B/B1,C,C/C1,C/C2,C/C3,D,D/D1,D/D2,D/D3,E"),
    MT507("A,A/A1,A/A2,B,B/B1,B/B1/B1a,B/B1/B1a/B1a1,B/B1/B1b,B/B1/B1b/B1b1,C"),
    MT508("A,A/A1,B,B/B1,C"),
    MT509("A,A/A1,A/A2,A/A2/A2a,B,B/B1,C"),
    MT510("A,A/A1,A/A2,A/A2/A2a,B,C"),
    MT513("A,A/A1,B,B/B1,C,C/C1,C/C2,C/C3,D,D/D1,D/D2,D/D3,E,F"),
    MT514("A,A/A1,B,B/B1,B/B2,C,C/C1,C/C2,C/C3,D,E"),
    MT515("A,A/A1,B,C,C/C1,C/C2,D,D/D1,D/D2,D/D3,E,F"),
    MT516("A,B,C"),
    MT517("A,A/A1"),
    MT518("A,A/A1,B,B/B1,B/B2,C,C/C1,C/C2,C/C3,D,E"),
    MT519("A,A/A1,B,B/B1,B/B2,C,C/C1,C/C2,D"),
    MT524("A,A/A1,B,B/B1,C"),
    MT526("A,B"),
    MT527("A,A/A1,A/A2,B,B/B1,C,D,E"),
    MT530("A,B,B/B1,C,C/C1,C/C1/C1a"),
    MT535("A,A/A1,B,B/B1,B/B1/B1a,B/B1/B1b,B/B1/B1b/B1b1,B/B1/B1c,C"),
    MT536("A,A/A1,B,B/B1,B/B1/B1a,B/B1/B1a/B1a1,B/B1/B1a/B1a2,B/B1/B1a/B1a2/B1a2A,C"),
    MT537("A,A/A1,B,B/B1,B/B2,B/B2/B2a,B/B2/B2b,B/B2/B2b/B2b1,C,C/C1,C/C2,C/C2/C2a,C/C3,C/C3/C3a,D,D/D1,D/D1/D1a,D/D1/D1a/D1a1,D/D1/D1a/D1a1/D1a1A,D/D1/D1a/D1a1/D1a1A/D1a1A1,D/D1/D1a/D1a1/D1a1B,D/D1/D1a/D1a1/D1a1B/D1a1B1,D/D1/D1a/D1a1/D1a1B/D1a1B1/D1a1B1a,D/D1/D1a/D1a1/D1a1B/D1a1B1/D1a1B1a/D1a1B1a1,E"),
    MT538("A,A/A1,B,B/B1,B/B2,B/B2/B2a,B/B2/B2a/B2a1,C"),
    MT540("A,A/A1,B,B/B1,C,C/C1,D,E,E/E1,E/E2,E/E3,F"),
    MT541("A,A/A1,B,B/B1,C,C/C1,D,E,E/E1,E/E2,E/E3,F"),
    MT542("A,A/A1,B,B/B1,C,C/C1,D,E,E/E1,E/E2,E/E3,F"),
    MT543("A,A/A1,B,B/B1,C,C/C1,D,E,E/E1,E/E2,E/E3,F"),
    MT544("A,A/A1,B,B/B1,C,C/C1,D,E,E/E1,E/E2,E/E3,F"),
    MT545("A,A/A1,B,B/B1,C,C/C1,D,E,E/E1,E/E2,E/E3,F"),
    MT546("A,A/A1,B,B/B1,C,C/C1,D,E,E/E1,E/E2,E/E3,F"),
    MT547("A,A/A1,B,B/B1,C,C/C1,D,E,E/E1,E/E2,E/E3,F"),
    MT548("A,A/A1,A/A2,A/A2/A2a,B,B/B1,C,C/C1,C/C1/C1a,C/C1/C1a/C1a1,C/C1/C1a/C1a1/C1a1A,C/C1/C1a/C1a1/C1a1A/C1a1A1,C/C1/C1a/C1a1/C1a1B,C/C1/C1a/C1a1/C1a1B/C1a1B1,C/C1/C1a/C1a1/C1a1B/C1a1B1/C1a1B1a,C/C1/C1a/C1a1/C1a1B/C1a1B1/C1a1B1a/C1a1B1a1,D"),
    MT549("A,A/A1,B,C,D"),
    MT558("A,A/A1,A/A2,A/A2/A2a,A/A3,B,B/B1,C,D,E"),
    MT564("A,A/A1,A/A2,B,B/B1,B/B2,C,D,E,E/E1,E/E1/E1a,E/E2,F"),
    MT565("A,A/A1,B,B/B1,B/B2,C,D,E"),
    MT566("A,A/A1,A/A2,B,B/B1,C,D,D/D1,D/D1/D1a,D/D1/D1b,D/D2,D/D2/D2a,D/D2/D2b,E"),
    MT567("A,A/A1,A/A2,A/A2/A2a,B,C"),
    MT568("A,A/A1,B,B/B1,C"),
    MT569("A,A/A1,A/A2,B,C,C/C1,C/C1/C1a,C/C1/C1a/C1a1,C/C1/C1a/C1a1/C1a1A,D"),
    MT575("A,A/A1,B,B/B1,B/B1/B1a,B/B1/B1a/B1a1,B/B1/B1a/B1a2,B/B1/B1a/B1a3,B/B1/B1a/B1a4,C,C/C1,C/C2,C/C2/C2a,D"),
    MT576("A,A/A1,B,B/B1,B/B2,B/B2/B2a,B/B2/B2b,B/B2/B2c,C"),
    MT578("A,A/A1,B,B/B1,C,C/C1,D,E,E/E1,E/E2,E/E3,F"),
    MT586("A,A/A1,B,B/B1,B/B2,B/B3,B/B4,B/B4/B4a,B/B5,B/B6,B/B6/B6a,B/B6/B6b,C"),
    MT600("A,B,C,D,D/D1,D/D1/D1a,D/D1/D1a/D1a1"),
    MT601("A,B,B/B1,B/B1/B1a,B/B1/B1a/B1a1"),
    MT620("A,B,C,D,E,F,G,G/G1,G/G2,H"),
    MT670("A,A/A1,A/A2,B,B/B1,B/B2,C"),
    MT671("A,A/A1,B,B/B1,B/B2,C"),
    MT760("A,B,C"),
    MT767("A,B,C");

    private final String sequences;

    MtSequenceEnum(String sequences) {
        this.sequences = sequences;
    }

    /**
    * Returns the sequence paths for this MT schema.
    * Each sequence path represents a hierarchical structure within the MT schema.
    *
    * @return A Set of sequence paths.
    *
    */
    public Set<String> sequences() {
        return Arrays.stream(sequences.split(","))
            .collect(Collectors.toSet());
    }

}
