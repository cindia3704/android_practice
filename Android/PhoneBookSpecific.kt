package com.example.myapplication.Android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_phone_book_main.*
import kotlinx.android.synthetic.main.activity_phone_book_specific.*

class PhoneBookSpecific : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_specific)
        Glide.with(this@PhoneBookSpecific)
            .load("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAwFBMVEUZcub///8XWbsYbNwAUbkWWLsAa+X3+f0AZuQAaeUAauUAbeUZc+cScOYAZ+UAZOTe6fvI2fi/0/YATLeStfFdlOtCh+k5gukwfugneueEq+/o8PyrxfSMsfCyyvXb5/ptne2hv/N1ou66zvVVkOt+qO+ftN6gu/GmwvPx9v3P3vgYZM7n7vxOi+pkmOwARrVehMqyw+QiYL42asF4lc+LpdfR2+/E0OkwctUAW80AXc6svuJPecZrjc4XX8ZBccS0Y9onAAAMpklEQVR4nOWdC3ObuBbHBbFlQAj8ijE4dnDiPOwkTpu06d29u7nf/1tdCTt+G5A4B+P2P7PTmc5O4WcJ6RzpPIiBrsbz7PaxG8WTXtAPXeKG/aA3iaPu4+3suYH/eIL5jw9mj3c9l1qeQyljXIoQkvzJGKWOZ9Gwd/c4G2C+BBbhoD18ob5HmWRKE2fU8+nLsI2FiUE4GMWhbVOeBbeByalth/EIgxKasNGKAt9hudk2xRw/iFrQnyYoYaMdUy9zXqYOJvVo3AaFBCRsz6ldCG8JyWw6b8O9FhRhM+LFRm8b0uPDJtCbwRCOehaFwltCUqs3Ank3AMJpl9qweEtIm3anFSBs3jjAw7fBSJ2bwpO1IGFz7uvtDHnF/HlBxkKEzUsPly9h9IoxFiAcYI/fitGfFzB2tAkbUQnjt2L0Im0rQJfwitHS+KQovyqV8LqPsj+kidv96/III6tsvoTRikoibJFyJ+halLTKILyxTsQnZd2gE87CUw3gQjSc4RJ2T/IFbopbXUTCaWCfmE/K7inZ4yqEM1beHp8mxlRmqgJh1z812kr+AwbhxDs114a8S3DCaf+0a+iuaD/vx5iT8Frh8LMccZ7TiMtH2PaqBigQvXwGTi7CK796gALRz+Vu5CF8rM4iui3/EYbw4ZSGaLry7BrZhN3qAgpLPNuEyySsNGAexCzCcbUBBeK4GOFVVReZtbJW1HTCUfUBBWL6/UYq4ewcAAViqquRRtgs/UBNT9xJOxRPIWyQ8wAUiCTFDE8hDKrh7+YRC3QIL6vlLqWLHvcXjxI+VMnhzZZ31H47Rtg6j2V0Lf+YL3WEcAoWdVCWODuy2hwhDM4NUCAeWW0OEw6dU7+vhpxhfsJZ1c3tw7IO2jYHCd3zm6NS3M1LGJ/TTrgpGucjbJ/nHJWyDsTDHSA8zym6EM9DeIc3R5PYZxkPjfYEepdNeI00Rzn1/HAedR+60Tz0PaxIMW/vJHyPsI8ShEetoLu5ls+6AXQ04/JJ/SzCK4w7UGoPn/dmz/PQxvge7N1jmx3CBsINDLeOBDQ17hDuzDnfedgOYQT/szrB8TOGZgBvHtId422bcADvFPrpYT4RvJfmbYf5bRPOoQ8uuJUVyjwCn6lsfpywCf2Dciv7jg/+btLf+iy2CC+hh/CQFbWPCL0Ds61Dm03Ca+ivMPNOYaEx9HO3tv1NQughPGjqHxK0M7M1iBuE0F/hYXftoKAd0s0vcYMwBh7CXB/hQtCfItuYPWvCAbC9xvMH9YgPBHgQ7fWeuCbsAn8M6TdCO4K+5aLrq+E1IfBFE+8pABpGDzptap/wCthCtNXyskbA38jaxVgRQv+ITC1BYgqd+7aaQl+ETeDVTGmdkYJea6yvDeOLMILe7ceKhGPoXf/Lp/kihD4d8lQDzmfAphtn24RtaNPQV82NnEL7NV57ixDanln9gvkFPYu+7JoFYQP63IuHyoQh7BuILbGxQdiGPmFT3O+lwK8sl9N0QQg9SXUIgTfk1TRdEIIfzu4fzGYK/Ch6abklhC3wIzYF3/BL8JeWi0DwhBB6uxfylQnhjxUXmz5BmSDCaNo/xk8XtNlIvj4VSThAiJ1xvisSfkcIjvAHS8IRwj/OfigS/kCIonNGS0LwvULqTZHwDeEdkv1CEkJbE4k6H0qAHx2MlwgXhNBHUIncmto0/VFzEd5CXtIQBJNNyq2/qngX09c6wksQu50QItwZCsLP2k8Fwp+1T4wxlHeJBMEglHIv6p385ToGnfoFBqE0jwUhUvayWf+Wm/Bb3cR5CVsSPuOEl7ifZifvrv+9Y6JM0sS0IkYLZwzdJzPvPH3u1M0nHEK7JQgfsGKgTLP+lufQtPFWN5EmKaEPghDFoiHJIJr192zExrsARBpCadUQxIBn0zRr71m74vS9ZqINoQyNJnjhsnIQzXo9PeX6ui5G0ETZKqSEJ06meCHdYjkViJ37FMD7jgREWkilnClpYmaOmFKd92NG+Md7J/k/EN/AaxKkzSKRe5EA1DvfDjF+fEsGEHGOErldEAz3d6Uloll/fb/f3hsH9++vCz5UQOEEE+g7n219IZr1Wuftx/2vj+fp88ev+x9vndqSDxeQ0DEZ4ubgrRAlZK3T6byK/2orPGxAwobkDjnL0CWf5nF9ElxAwu5IjB6avzGMu0IeQCEekwl+8oFLng7yPWEPoBCfEBT/d1eCcXeufpbBJ31gUlIenuuSi88vys/PC/kXZYgHBCX74KDcFZRbEh6RJ/skPOckoGzxsJSP4ZT63fkk4e/O6P4B32F5aylJWpMkvUpKe6RcS0vYDwUYtT3L5/1JLDTpM9/3PCe7fwnEswPSw30Co57lvtw83F5v+YfT5mz0cPcSClBcTmHTvKA9gIuBC+NxK+1YuDEbRYHtqXRsUXyJFyTfgjPbCobtnBdss/ElQ8oqFb4Fgn/ImcfiW8XgxNkwxIAU/iG4j89teqNRlFqo2Q0t8AjFIfQ5DfN6t1p4y5G8obAnY3QMe9bG/Bu90vBrNcYuZLqecwt5XsrsO5CWVKMQ7pTabsGdeXM/Bmu5NXIdoHH0mmD3Fl4Pqn1RojGFWQGdKdDdE/d0208c0/QSIkFY3j2B3B86Lwg94doABdKT+0OAO2C9xhOZmk4Kr4LJHXDhe/zsjHRtDYvGiST3+IWDvhzV9BgFFS0Qa7cB4mlo0T0+VQXrUCfxNEahDZHbqICG0S30enbxuDYfsFPhYUUFEJdxbUViEz3FhiE6KpCtT6Oi8aVsgg9oGC/a+9kyvrRIyZYSOhYLd0PbabQHBeO8vSKuoIJGumOwjPPWtmqOVZuEl+ah7ipWX9cJdtBsmV1pptKv8i10c2YoQJfQfJrqWSWrnBnNSaCRY6gtLQdonfekmbvG9iv4oUlrqVhU/SqQf0gVmi4V1VBn19/IP9TLIVUuKlBAOi7eZg6p5iSoOOFWHrCW4VZ1wq1cbq18/IoTbufja03TihNu11TQqotRccKduhg6VSmqTbhb20Rn06824V59Go1k8WoT7tUY0jitqTThfp0ojQLClSY8UOtL3XKjJZxCfUl1mThUr0295h5T76+srbniz3+w5p5y0jr/T3mET4rvdrBuorJd4/5Vmo///JdaCOXm9CpQv9T9Oy0rDVQ//1YjPFK/VLUGrfukWvtCW3W1HNNjNWhV6wi7T53/lgP4s6aWenK0jrDiILoX9XopZ96DjlpyzfFa0Ma14pdo1v8pg/BdsR5BSj1vxZrsrmkqVjDR0j81U6ksSFpNdsVLGpnK3PkXma8hANWS2VPr6iue2smktNo7aKTQrn6Zqsns6b0RFPtbLJK1X/9VreuVWx//JKm0KkOY1d9C1cVIErVqnf/dfzSgNfh1/75MhVZ5o6weJYp3GKtM5ppMfQVV53WVKqyyVWT3mVHsFeSucyfrsNpIxFRZZqzsXkGK/Z7cw+mhgFLa7PP0e1Lt2ZWS5Qsh1epK+zjF+64dy/IF4VOs6pKz75pyAMuBLF8QyVxapRfJ2ztPo5SoTHu9AJZ6Lm3+/od/QA/L378P6R/QS/YM+wETxX7Av39P5z+gL/cf0Fv9rFabtBjCFMJpmTnXhcR5yul7CqHRBG4fhCXupR2kpBGey4J6dBnNJjSuzgHRT08qSycsmtBRhvzHdIQMQuOh6ka4lRUhmUVodKuNaGVetWcSVhsxGzAHoTGu7rfoj7NfPwdhdVfUjFU0P6Ex8qu49XM/V0JLLkJjVkHrhufM7MxHaDQrZ6NynvPOKyehMe1Xy5mi/byhLnkJDWNSJZfYy58WmJ/Q6FZmveG+QkidAqHRqsjxFGcq9W9UCI1pUIVzVDtQKuCgRChLAJx6GLl1+OAXitCYuaddU6mrWt9AldAwbk5piVvqMa3qhEbrZMNIXY0SWxqEsgjAKb5G7mmVUNEiNK6D0hm5F+jVp9AjFO4GL3eqUq6bVq1LaDSGHnI19w0xb6gd56lNaBiDuV8OI/PnBYo0FSAUPtVlCePIvMtCsYGFCMWSc4k8jsy/LFgApyChYIxtnLqcJKmAGhcu8FOYUHyPXYpyyMFtpwtQJA2AUGjUs4AHklOrB1N2A4ZQLDoR88DcR1niNYIKPYYiFGrPqQ0AyZlN54DVpwAJhRXQjmmxkRSjR+M2aBYHKKFQoxX1fUdvB2GO349a0Ekq0IRSg1Ec2rZKBWsu9gU7jEcI9SVRCKUG7eEL9T3KMjhlvXbPpy/DNgadFBZhokFrfBO4juU5lCb19BPc5E/GKHU8y3GDm/Sa5oWFSrjQ9Hl2+9iN4kkv6IcuccN+0JvEUffxdvZcQo7m/wGDvu0RvS3IyQAAAABJRU5ErkJggg==")
            .centerCrop()
            .into(contact_photo)

        Glide.with(this@PhoneBookSpecific)
            .load("https://www.pinclipart.com/picdir/big/129-1293919_small-phone-icon-blue-clipart.png")
            .fitCenter()
            .into(phone_icon)

        Glide.with(this@PhoneBookSpecific)
            .load("https://www.pngfind.com/pngs/m/104-1043692_search-icon-transparent-white-search-icon-apple-png.pnghttps://cdn4.vectorstock.com/i/1000x1000/58/68/talking-bubble-chat-icon-vector-21105868.jpg")
            .fitCenter()
            .into(chat_icon)

        val name=intent.getStringExtra("name")
        val phoneNum=intent.getStringExtra("phoneNumber")
        val type=intent.getStringExtra("type")
        Log.d("phone","phone: "+phoneNum)


        val contact_name = findViewById<TextView>(R.id.name_specific)
        val contact_phone=findViewById<TextView>(R.id.phoneNum)
        val contact_type = findViewById<TextView>(R.id.type)
        contact_name.setText(name)
        contact_phone.setText(phoneNum)
        contact_type.setText(type)

        back.setOnClickListener{
            onBackPressed()
        }

    }
}