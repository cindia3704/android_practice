package com.example.myapplication.Android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        Realm.init(this@RealmActivity)
        // Migration= database를 동기화(테이블의 sync를 맞출때) 시키겠다라는 뜻 -- 디비를 바꾸게 될때
        //.deleteRealmIfMigrationNeeded() <-- 디비의 틀에 변경이 생기면 ==> migration이 필요해진거고 ==> 그러면 realm을 지워주겠다.(지우고 다시하겠다,)
        val config: RealmConfiguration=RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(config)
        // Realm 얻기
        val realm = Realm.getDefaultInstance()

        // Realm 사용하기 ==============================================
        //1. table 만들기 --> School.kt보렴
        //2.
        button_save.setOnClickListener {
            realm.executeTransaction{
                // Transaction = 디비 처리할때 한 단위 (작업단위를 묶어두는것) -- begin  & commit을 묶었다고 생각하면 됨
                // A table에서 데이터를 가져온다
                // B table에서 데이터를 가져온다
                // C table에서 데이터를 가져온다
                // 조합을 한다
                // D table에 저장을 한다

                with(it.createObject(School::class.java)){
                    //Data 생성한것
                    this.name="어떤 대학교"
                    this.location="서울"
                }
            }
        }
        button_load.setOnClickListener {
            realm.executeTransaction{
                //데이터 찾아오기
                //해당 테이블에 가기                           어떤걸 갖고올것인가?
                val data= it.where(School::class.java). findFirst()
                Log.d("dataa","data: "+data)
            }
        }
        button_delete.setOnClickListener {
            realm.executeTransaction{
                it.where(School::class.java).findAll().deleteAllFromRealm()         // 전체 지우기 
                //it.where(School::class.java).findFirst().deleteFromRealm()        <-- 첫번째꺼만 지우기
            }
        }
    }
}