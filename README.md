### Used Packages

#### Selenide 7.0.2
#### Junit 4.13.2

### testing environment:
#### Linux debian 12 bookworm
#### Firefox 120.0.1
#### date: 13.12.2023

## ID: TC_01
### test title: Регистрация нового пользователя
#### priority: high
#### precondition:
	у нас есть неиспользованные почта и username 
#### test steps:
	1. открыть страницу https://angular.realworld.io/register
	2. заполнить форму с полями: Username, Email, Password валидными данными
	3. нажать на enter
#### test data:
	1. https://angular.realworld.io/register
	2. Username: dimetrius, Email: volk@gmail.com, Password: "qf4fo87&"
	3. -
#### expected result:
	1. появляется страница с формой регистрации
	2. в полях отображаются наши данные
	3. открывается главная страница на вкладке "Your feed"
#### real result:
	1. появляется страница с формой регистрации
	2. в полях отображаются наши данные
	3. открывается главная страница на вкладке "Your feed"
#### status:
	pass


## ID: TC_02
### test title: создание статьи и проверка созданной статьи в "Global feed"
#### priority: high
#### precondition:
	Мы прошли аутентификацию
#### test steps:
	1. открыть страницу https://angular.realworld.io/
	2. нажать на кнопку "New Article"
	3. Заполнить поля для создания статьи валидными данными
	4. нажать на кнопку "Publish Article"
	5. нажать на кнопку "Home" либо на логотип слева чтобы перейти на главную страницу
	6. нажать на кнопку "Global Feed"
#### test data:
	1. https://angular.realworld.io/
	2. -
	3. Article Title: Exploring Angular Lazy Loading
	What is this article about: Learn how to optimize your Angular applications by implementing lazy loading. Dive into the details of lazy loading modules, routes, and components to enhance performance and improve user experience.
	Article content: Angular applications can benefit significantly from lazy loading, a technique that defers the loading of certain modules or components until they are actually needed. This optimization strategy contributes to faster initial page loads and reduces the overall application bundle size.
	What is Lazy Loading in Angular?
	Lazy loading is a design pattern that enables loading parts of an application on-demand, rather than upfront. In Angular, this is achieved by dividing the application into feature modules and loading them only when necessary. This can lead to a better user experience by minimizing the initial load time and decreasing the amount of data transferred over the network.
	tags: Lazy Loading, Performance Optimization, Angular Modules, Angular Routes, Angular Components
	4. -
	5. -
	6. -
#### expected result:
	1. открывается страница со статьями
	2. появляется форма создания статьи
	3. в полях отображаются наши данные
	4. открывается страница в котором созданная нами статья
	5. открывается главная страница с вкладкой "Your feed"
	6. загружаются статьи, созданная нами статья находится первая в очереди
#### real result:
	1. открывается страница со статьями
	2. появляется форма создания статьи
	3. в полях отображаются наши данные
	4. открывается страница в котором созданная нами статья
	5. открывается главная страница с вкладкой "Your feed"
	6. загружаются статьи, созданная нами статья находится первая в очереди
#### status:
	pass
