# Reddit-PIcs-Browser

 # Introduction

<a href="https://circleci.com/gh/DavidEdwards/mvvm-example" rel="nofollow"><img src="https://camo.githubusercontent.com/8bcd2a6949804ef9f16e822984794564127f9aae/68747470733a2f2f636972636c6563692e636f6d2f67682f4461766964456477617264732f6d76766d2d6578616d706c652e7376673f7374796c653d73766726636972636c652d746f6b656e3d32613338646336323061396133313636366661646236366565326366396633383237343936326338" alt="CircleCI" data-canonical-src="https://circleci.com/gh/DavidEdwards/mvvm-example.svg?style=svg&amp;circle-token=2a38dc620a9a31666fadb66ee2cf9f38274962c8" style="max-width:100%;"></a>   <a target="_blank" rel="noopener noreferrer" href="https://camo.githubusercontent.com/94a7fdde39447afc77c39c944b11c42a7bee5237/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4150492d31372532422d627269676874677265656e2e737667"><img src="https://camo.githubusercontent.com/94a7fdde39447afc77c39c944b11c42a7bee5237/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4150492d31372532422d627269676874677265656e2e737667" alt="API" data-canonical-src="https://img.shields.io/badge/API-17%2B-brightgreen.svg" style="max-width:100%;"></a>

This is a demo app using Reddit api. We are fetching pics from the api and show them in a list.

Proudly 💪  made in Kotlin

<h4>Features</h4>
<ul>
  <li>Get list of pics and show as a list</li>
   <li>Show preview on item click</li>
  </ul>


<h4>Architecture</h4>

MVVM is one of the architectural patterns which enhances separation of concerns, it allows
separating the user interface logic from the business (or the back-end) logic. Its target 
(with other MVC patterns goal) is to achieve the following principle “Keeping UI code simple 
and free of app logic in order to make it easier to manage”.

<ul>
<li>LiveData: It notifies views of any database changes. Use LiveData to build data objects that notify views when
the underlying database changes.</li>
<li>ViewModel: It manages UI-related data in a lifecycle-conscious way. It stores UI-related data
that isn't destroyed on app rotations.</li>
<li>RxJava : It is a library for composing asynchronous streams of real-time data and event-based programs by using observable sequences in a Reactive Programming style
<br>

</ul>

<h4>Library used</h4>
<ul>
<li><a href="https://developer.android.com/topic/libraries/architecture/viewmodel" target="_blank">Viewmodel</a></li>
<li><a href="https://developer.android.com/topic/libraries/architecture/livedata">Livedata</a></li>
<li><a href="https://github.com/google/dagger" target="_blank">Dagger2</a></li>
<li><a href="https://github.com/google/dagger" target="_blank">Dagger Android</a></li>
<li><a href="https://github.com/ReactiveX/RxJava" target="_blank">RxJava</a></li>
<li><a href="https://github.com/square/retrofit" target="_blank">Retrofit</a></li>
<li><a href="https://github.com/bumptech/glide" target="_blank">Glide</a></li>
<li><a href="https://github.com/casidiablo/multidex" target="_blank">Multidex</a></li>
  
  
</ul>


