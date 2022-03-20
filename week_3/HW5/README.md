# Week3 - HW5

Sigorta firması için bir yazılım yaptığınızı düşünün. Sigorta firmasının "Bireysel" (Individual) ve "Kurumsal" (Enterprise) olmak üzere iki tip müşteri profili bulunmaktadır. Müşteri profili için "Account" isminde soyut sınıf (abstract class) tasarlayınız. Account sınıfı müşterinin sisteme giriş sonrasında tüm bilgilerinin tutulduğu hesap bilgisidir. "Account" sınıfı içinde "User" tipinde bir nesne referansı bulunur. (Aggeration ilişkisi olarak)

"User" sınıfı müşterinin kişi bilgilerini ifade eder. "User" sınıfında müşterinin

- isim (String),
- soyisim (String),
- email (String),
- şifre (String),
- meslek (String),
- yaş (int),
- adres listesi (ArrayList),
- sisteme son giriş tarihi (Date),

bilgileri bulunur. Ayrıca, "User" sınıfında ArrayList tipinde adreslerinin tutulduğu bir liste vardır. Adres bilgisi iki tiptir. Ev adresi ("HomeAddress") ve İş adresi ("BusinessAddress") olmak üzere iki tane sınıf tasarlayınız. Bu adres sınıfları "Address" isimli bir interface'den kalıtım alacaktır. Fakat, bu interface'de hangi fonksiyonların olması gerektiğine siz karar vereceksiniz.

Müşteri adreslerinin ekleyip çıkarılma sorumluluğunu üstlenmiş olan "AddressManager" isminde bir sınıf tasarlayınız. Bu sınıfın içinde "User" nesnesinin adres listesine eleman ekleme-çıkarma yapabilen iki tane static fonksiyon tanımlayınız. Bu fonksiyon isimlerini siz belirleyiniz.

- "Account" sınıfında müşteri bilgilerini ekrana yazdıran "final" tipinde, değer döndürmeyen ve ismi "showUserInfo" bir fonksiyon tanımlayınız.

- "Account" sınıfında müşterilerin yaptırdıkları sigortaları liste halinde saklayınız. Sigortayı temsil eden "Insurance" isminde bir soyut sınıf tasarlayınız. 

Bu soyut sınıf içinde,

- sigortanın ismi (String),
- sigortanın ücreti (double)
- sigortanın başlangıç-bitiş tarihi (Date)
gibi değişkenlere sahip olacaktır.

- Ayrıca "calculate" isminde soyut bir fonksiyon tanımlanacaktır. Bu soyut fonksiyon aşağıda kalıtım alınan sınıflarda doldurulacaktır.

Bu soyut sınıftan türeyen
- "HealthInsurance" (özel sağlık sigortasu),
- "ResidenceInsurance" (konut sigortası),
- "TravelInsurance" (seyahat sigortası),
- "CarInsurance" (otomobil sigortası)

4 tane alt sınıf tasarlayınız. Her alt sınıf "calculate" isimli soyut fonksiyonu override ederek, sigorta ücretini kendine göre hesaplayacaktır.