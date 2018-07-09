/*
 *
 * Copyright 2018 Odysseus Data Services, inc.
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
 *
 * Company: Odysseus Data Services, Inc.
 * Product Owner/Architecture: Gregory Klebanov
 * Authors: Pavel Grafkin, Vitaly Koulakov, Maria Pozhidaeva
 * Created: April 4, 2018
 *
 */

package com.odysseusinc.athena.service.saver.common;

import com.odysseusinc.athena.service.saver.Saver;
import com.odysseusinc.athena.service.saver.SaverV4;
import com.odysseusinc.athena.service.saver.SaverV5;
import org.springframework.stereotype.Service;

@Service
public class ConceptRelationshipSaver extends Saver implements SaverV4, SaverV5 {

    @Override
    public String fileName() {

        return "CONCEPT_RELATIONSHIP.csv";
    }

    @Override
    protected String query() {

        return "SELECT * FROM concept_relationship WHERE EXISTS "
                + "(SELECT 1 FROM CONCEPT WHERE CONCEPT_ID_1 = CONCEPT_ID AND VOCABULARY_ID IN (?)) "
                + "AND EXISTS (SELECT 1 FROM CONCEPT WHERE CONCEPT_ID_2 = CONCEPT_ID AND VOCABULARY_ID IN (?))";
    }
}
