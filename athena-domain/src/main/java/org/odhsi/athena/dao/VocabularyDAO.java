package org.odhsi.athena.dao;

import org.odhsi.athena.entity.Vocabulary;

import java.util.List;

/**
 * Created by GMalikov on 26.03.2015.
 */

public interface VocabularyDAO{

    public Vocabulary getVocabularyById(String id);

    public List<Vocabulary> getAllVocabularies();

    public String getVocabularyStatus(String id);


}
