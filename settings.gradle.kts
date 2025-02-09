pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "LibraryWidget_Android_JAVA"
include(":app")
include(":app:BottomSheetDialog")
include(":app:BottomSheetDialogFragment_imagen")
include(":app:BottomSheetDialogFragment_ListCardView")
include(":app:AlertDialogView")
include(":app:BottomSheetDialogFragment_Notification")
include(":app:ExpandableListView")
include(":app:ExpandableListView_itemCardView")
