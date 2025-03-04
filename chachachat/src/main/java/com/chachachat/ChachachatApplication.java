////////////////////////////////////////////////////////////////
package com.chachachat;
////////////////////////////////////////////////////////////////
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
////////////////////////////////////////////////////////////////
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
////////////////////////////////////////////////////////////////
@SpringBootApplication
public class ChachachatApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory
        .getLogger( ChachachatApplication.class );
                                                                 
    private final MessageRecordRepo messageRecordRepo;
    
    public
    ChachachatApplication( MessageRecordRepo messageRecordRepo ){
        this.messageRecordRepo = messageRecordRepo;
    }
	public static void main( String[] args ){
		SpringApplication.run( ChachachatApplication.class, args );
	}
    @Override
    public void run( String ... args ) throws Exception {
        messageRecordRepo
            .save( new MessageRecord( "Hello World!" )); 
        messageRecordRepo
            .save( new MessageRecord( "Hi Anton!" )); 
    }
}
////////////////////////////////////////////////////////////////
//
// #############################################################
// #############################################################
// #############################################################
// #############################################################
////////////////////////////////////////////////////////////////
// 1. あした、アルバイトがありますか。
//    いいえ、ありません。
////////////////////////////////////////////////////////////////
// 2. いつ日本語のクラスがありますか。
//    木曜日にあります。
////////////////////////////////////////////////////////////////
// 3. 日本に友だちがいますか。
//    いいえ、いません。
////////////////////////////////////////////////////////////////
// 4. 兄弟がいますか。
//    はい、おねえさんがいます。
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
