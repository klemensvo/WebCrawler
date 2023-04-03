# WebCrawler
WebCrawler is a project of an assignment of the course Clean Code at AAU Klagenfurt  
## Authors
- Olha Kupar  
- Klemens Vospernik

## Basic structure  
### Main
entry point

### UserQuery  
url  
crawlDepth  
targetLanguage

### HandleWebsite
can be called recursively

### WebCrawler
crawlWebsite
#### RecordHeadings
findHeadings
#### TranslateHeadings
translateHeadings
#### RecordURLs
findURLs

### RenderMarkdownFile
displayHeadings  
displayFunctionalURLLinks  
displayBrokenURLLinks
