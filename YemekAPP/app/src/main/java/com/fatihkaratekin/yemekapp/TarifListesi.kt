package com.fatihkaratekin.yemekapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TarifListesi : AppCompatActivity() {
    private lateinit var images: List<Triple<String,String, Int>>
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: YemekListesiAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tarif_listesi)


        val searchView: SearchView = findViewById(R.id.searchView)
        recyclerView = findViewById(R.id.recipesRecyclerView)

        val layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        images = listOf(
            Triple("Salçalı Makarna","4 litre suyu kaynatalım ardından tuz ve yağı içerisine ekleyelim.Makarnayı suya dökelim 10-12 dakika arada karıştırarak tencerenin ağzı açık olacak şekilde pişirelim." +
                    "Haşlanan makarnayı süzgece dökelim suyundan yarım çay bardağı ayıralım.Tenceremize yağı ekleyelim ve ardından beklemeden salçaları ve sarımsağı atalım." +
                    "Salçanın kokusu çıkana kadar kavuralım bu sırada makarna suyunu azar azar ekleyerek salçamızı krema kıvamına getirelim." +
                    "Sosun baharatlarını ekleyelim ve süzülen makarnayı tencere dökelim.2 dakika kadar sosuyla beraber makarnayı kavuralım. Afiyet olsun.   . \n", R.drawable.makarna),
            Triple("Et Kavurma","İlk önce tencere ısıtılır ve ısınan tencereye iç yağı konulur. İç yağ eridikten sonra, tencerenin dibine çöken minik et parçalarını bir süzgeç yardımıyla alın.Daha sonra iç yağının içerisine, küçük doğranan" +
                    "etleri koyun.5-6 dakika yüksek ateşte kavurun.İçine 1 adet bütün kabuksuz soğanı atıyoruz.Bu pişerken ete daha da lezzet katacaktır.1 bardak su ilave ediyoruz.Tencerenin altını kısıyoruz.10 dakikada bir karıştırıp, tekrar tencerenin kapağını kapatıyoruz." +
                    "Etler pişince baharatlarını ekliyoruz. (Kimyon, kekik, tuz, karabiber)Sıcak olarak servis ediyoruz.Afiyet olsun….\n", R.drawable.kavurma),
            Triple("Pilav","Pirinçleri bol suda yıkayarak ılık ve tuzlu su dolu bir kapta 30 dakika dinlendirelim.Bu süre sonunda pirinçleri süzgeçten geçirin." +
                    "Tefon tencerede tereyağı eritin, sıvı yağ da ekleyerek üzerine arpa şehriyeleri katın.Şehriyelerin rengi dönene kadar kavurun.Şehriyelerin rengi dönene kadar kavurun." +
                    "Üzerine sıcak suyunu ve tuzu ilave edin.Tencerenin kapağını kapatarak önce yüksek ateşte,fazla suyu çekip pirinçler göz göz oluncaya kadar kaynatın." +
                    "Daha sonra yani pirinçlerin üzerindeki su çekilip pirinçler göründüğünde kısık ateşe alın.Tamamen suyu çekene kadar pişirin." +
                    "Ocaktan aldıktan sonra üzerine temiz bir bez koyarak kapağını tekrar kapatın ve demlenmesini bekleyin.Pilavı hafifçe karıştırdıktan sonra servis yapabilirsiniz.Afiyet olsun..\n", R.drawable.pilav
            ),
            Triple("Ispanak"," Ispanakları yıkayıp doğruyoruz, bir süzgece alıp diriliklerini kaybetmesi için üzerinden kaynar su akıtıyoruz. (bir çaydanlık dolusu yeterli)  Elimiz değecek sıcaklığa gelince avucumuzda fazla suyunu sıkıyoruz, karıştırma kabına alıyoruz.\n" +
                    " Diğer malzemeleri de ekleyip karıştırıyoruz ve yuvarlak veya kare borcama kek gibi yayıyoruz." +
                    " Üzerine kaşar rendesi serpip dilimlenmiş domates ile süslüyoruz.180 derecede üstü kızarana kadar pişiriyoruz.Afiyet olsun.\n", R.drawable.ispanak),
            Triple("Sarma","Öncelikle salamura yapraklar 2-3 dakika sıcak suda bekletilir, yıkanır ve süzgece alınır.Geniş bir kabın içerisine soğanlar rendelenir üzerine zeytinyağı dökülür." +
                    "Pirinç yıkanarak  kabın içerisine eklenir.Baharatlar, salça ve tuzu da ilave edildikten sonra ince kıyılmış maydanozu daeklenerek karıştırılır.(çiğden bir iç harç olacak)" +
                    "Yaprağın geniş kısmına iç harçtan konulur ve rulo gibi iki yanlardan kapatarak sarılır. Bu işleme yaprak bitene kadar devam edilir." +
                    "Sardığımız yaprakların üzerine zeytinyağı ve limon dilimleri ekleyip yaklaşık 5-6 su bardağı kadar da sıcak su ilave edilerek kısık ateşte pişirilir.(üzerine sarmalar dağılmasın diye tencere kapağından biraz küçük ebatta bir kase kapatabilirsiniz.) Afiyet olsun…\n", R.drawable.sarma),
            Triple("Kızartma Tavuk","Bir kaseye salça, yoğurt, zeytinyağı ve baharatları koyun ve karıştırın.Bütün tavuğu uygun bir fırın kabına alın ve fırça yardımıyla sosunu üzerine sürün. Kalan sosu su ile karıştırıp fırın kabının tabanına dökün. Buzdolabında en az 1 saat bekletin." +
                    "Önceden ısıtılmış 190 derece fırında 40 dakika pişirin. Üzeri nar gibi kızarmış isterseniz 5 dakika daha 200 derecede pişirmeye devam edin." +
                    "Pirinç pilavı ile servis edin. Afiyet olsun!\n", R.drawable.tavuk),
            Triple("Kek","İlk olarak kekimizin hamurunu hazırlıyoruz. Yumurta ve şeker iyice çırpılır.\n" +
                    "Daha sonra diğer malzemeler ilave edilir ve tekrar çırpılır.\n" +
                    "Kuru malzemeleri eleyerek ilave etmekte fayda var. Kek hamurumuz hazır.\n" +
                    "Kekimizi pişmeye bırakıyoruz. Sade kek hamurumu yağlanmış kek kalıbına dökülür.\n" +
                    "160 derecede önceden ısıtılmış fırında yaklaşık 50 dk kadar pişirilir. Pişirme esnasında ilk 30 dk kapağı açmayalım. 30 dk sonrasında da kabarmış ve üzeri pembeleşmiş kekimizi gözlemlemeye başlayabilirsiniz. Kenarlar kalıptan ayrılmış kekimizi kürdan testini de yaptıktan sonra fırından alıp soğumaya bırakabiliriz.\n" +
                    "Pişen keki kalıptan çıkartıyoruz. Fırından aldıktan en az 15 dk kadar sonra ilk sıcaklığı çıkan yumuşacık sade keki kalıptan çıkartabilirsiniz. Afiyet olsun.\n" +
                    "Sizler de misafirlerinize veya ailenize çayın yanında lezzetli sade baton kek tarifini kolaylıkla hazırlayabilirsiniz.\n" +
                    "\n" +
                    "Az malzemelerle, beğenilere sunabileceğiniz muhteşem kek tarifini denemenizi öneririm. :).\n", R.drawable.kek),
        )



        adapter = YemekListesiAdaptor(images)
        recyclerView.adapter = adapter


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }


            override fun onQueryTextChange(newText: String): Boolean {
                filter(newText)
                return true
            }
        })

    }

    // değişen yazıyı alıp veri listemizi filtreledik ve adaptore gönderdik
    private fun filter(query: String) {
        val filteredList = images.filter { it.first.contains(query, ignoreCase = true) }
        adapter.setData(filteredList)
    }

}

