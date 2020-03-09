//package com.praveen.cms.api.search;
//
//import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
//import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilterFactory;
//import org.apache.lucene.analysis.snowball.SnowballPorterFilterFactory;
//import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
//import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurationContext;
//import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurer;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class HibernateLuceneAnalysisConfig implements LuceneAnalysisConfigurer {
//
//    @Override
//    public void configure(LuceneAnalysisConfigurationContext context) {
//        context.analyzer( "english" ).custom()
//                .tokenizer( StandardTokenizerFactory.class )
//                .tokenFilter( LowerCaseFilterFactory.class )
//                .tokenFilter( SnowballPorterFilterFactory.class )
//                .param( "language", "English" )
//                .tokenFilter( ASCIIFoldingFilterFactory.class );
//
//        context.analyzer( "name" ).custom()
//                .tokenizer( StandardTokenizerFactory.class )
//                .tokenFilter( LowerCaseFilterFactory.class )
//                .tokenFilter( ASCIIFoldingFilterFactory.class );
//    }
//}
