## Здравствуй, ИНТЕРНЕТ!
## Досвидания, интернет!

// вот так было не плохо

git config --global user.name .email , color.ui auto ,list	git remote -v список подключ к remote репам
git init репа в текущей папке		-a все (файлы напр)		git status (ветка, комиты)
git remote add origin https://github.com/repoAdress подключение локального репо к сайту
git add добавить файл в репо  (add . все файлы в дире)
git commit режим записи commit     -a все изменения в раб папке -am плюс сбщ'
commit --ammend перезапись последнего (старый отцеплен reset)
.gitkeep доб пуст папку в репо	.gitignore правила для папки (config index ignore files)
 git reset хэш (куда вернуться) сброс до состояния (файлы останутся в исход состояние)
git log история коммитов (--oneline, --all все ветки)	git reflog история(отмены комитов, переходы итд)
git reset хэш (куда вернуться) сброс до состояния (файлы останутся в исход состояние)
git reset восстановление -на хэш что был "удален'
git revert отмена коммита - создание комита с противоположными действиями
git branch NAMEBRANCH *ИмяДругойВеткиРодителя(опционально)  - создание ветки
git branch -d удалить ветку (после слияния напр)
git push --delete origin NameBranch удаление ветки с remote репозитория
git checkout переключение на ветку(коммит как restore *читать)
git push экспорт коммитов в ВеткиНаСервере (--force перезапись локальной версию на сервер) 
git push -u origin NameBranch		git pull это fetch и merge
git fetch скачивание коммитов в локалВетку (скач remote ветки)
git merge слияние коммитов remote ветки с текущей локальной (master)
git rebase  (наприм. при разработки своего модуля понадобился модуль другого разработчика, замена одного snapshota например на актуальный)    	 урок 9 см
git tag версия проекта (git push --tags) (-d удал или git push --delete origin 1.0.1)
pull request - запрос merge двух веток на портале gitHub. 
git stash - локальные тайник для файлов незакоммичиных. Можно с ветки на ветку 		 stash list, 
stash push fileName - добавить файл к существующему стешу.
stash pop stash@{1} вернуть в незакоммиченное
git cherry-pick ХэшКомита (посл коммит, все коммиты) взять с другой ветки коммит