"use client";
import Link from "next/link";
import { useEffect, useState } from "react";
import forwardIcon from "../../../public/forward.png";
import previousIcon from "../../../public/left-arrow.png";
import Image from "next/image";
const fakeData = [
  {
    groupBy: "Main 1",
    child: [
      {
        name: "this is blog 1",
        slug: "this-is-blog-1",
      },
      {
        name: "this is blog 2",
        slug: "this-is-blog-2",
      },
      {
        name: "this is blog 3",
        slug: "this-is-blog-3",
      },
    ],
  },
  {
    groupBy: "Main 2",
    child: [
      {
        name: "this is blog 4",
        slug: "this-is-blog-4",
      },
      {
        name: "this is blog 5",
        slug: "this-is-blog-5",
      },
      {
        name: "this is blog 6",
        slug: "this-is-blog-6",
      },
    ],
  },
];

const fakeBlogData = {
  name: "Blog about this and that",
  content:
    " Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum,expedita obcaecati? Rem nobis, porro, maxime deserunt saepe quasaliquam suscipit excepturi placeat nesciunt amet laboriosam sitarchitecto illum aspernatur non!",
  lastUpdated: "2023-12-12",
};

export default function Category() {
  const [blogTitle, setBlogTitle] = useState<any>([]);
  const [blogContent, setBlogContent] = useState<any>(null);

  useEffect(() => {
    setBlogTitle(fakeData);
    setBlogContent(fakeBlogData);
  }, []);
  return (
    <div className="hello-world d-flex p-3">
      {/* side bar */}
      <div className="side-bar w-25 d-flex flex-column align-items-end">
        {(blogTitle || []).map((item: any) => (
          <div key={item["groupBy"]} className="w-50 ">
            <div className="h6 pt-1">{item["groupBy"]}</div>
            {(item["child"] || []).map((c: any) => (
              <div key={c.slug} className="p-1">
                <Link href={c.slug}>{c.name}</Link>
              </div>
            ))}
          </div>
        ))}
      </div>
      {/* main content */}
      {blogContent && (
        <div className="main w-75 d-flex flex-column align-items-center">
          <div className="w-75 py-5 text-center">
            <div className="h3">{blogContent.name}</div>
            <div className="h6 font-italic">
              Last updated: {blogContent.lastUpdated}
            </div>
          </div>
          <div className="content w-75">
            <div>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum,
              expedita obcaecati? Rem nobis, porro, maxime deserunt saepe quas
              aliquam suscipit excepturi placeat nesciunt amet laboriosam sit
              architecto illum aspernatur non!
            </div>
            <div>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum,
              expedita obcaecati? Rem nobis, porro, maxime deserunt saepe quas
              aliquam suscipit excepturi placeat nesciunt amet laboriosam sit
              architecto illum aspernatur non! Lorem ipsum dolor sit amet
              consectetur adipisicing elit. Natus quia aliquam, ad voluptas
              sequi perferendis quam sint est architecto? Facilis itaque nulla
              sequi nisi autem! Quas vero deserunt quibusdam magnam? Lorem ipsum
              dolor sit amet consectetur, adipisicing elit. Cumque tenetur
              exercitationem voluptate esse id? Explicabo mollitia voluptatem,
              eius labore tempore quo placeat impedit est eaque ad nobis
              quibusdam esse id. Lorem ipsum dolor sit amet consectetur
              adipisicing elit. Blanditiis dolores ducimus reiciendis
              reprehenderit temporibus iure quaerat placeat assumenda natus
              officiis error quam, recusandae molestias ratione consectetur
              alias quia voluptatem ipsum!
            </div>
            <div>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum,
              expedita obcaecati? Rem nobis, porro, maxime deserunt saepe quas
              aliquam suscipit excepturi placeat nesciunt amet laboriosam sit
              architecto illum aspernatur non!
            </div>
            <div>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum,
              expedita obcaecati? Rem nobis, porro, maxime deserunt saepe quas
              aliquam suscipit excepturi placeat nesciunt amet laboriosam sit
              architecto illum aspernatur non!
            </div>
            <div>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum,
              expedita obcaecati? Rem nobis, porro, maxime deserunt saepe quas
              aliquam suscipit excepturi placeat nesciunt amet laboriosam sit
              architecto illum aspernatur non! Lorem ipsum dolor sit amet
              consectetur adipisicing elit. Natus quia aliquam, ad voluptas
              sequi perferendis quam sint est architecto? Facilis itaque nulla
              sequi nisi autem! Quas vero deserunt quibusdam magnam? Lorem ipsum
              dolor sit amet consectetur, adipisicing elit. Cumque tenetur
              exercitationem voluptate esse id? Explicabo mollitia voluptatem,
              eius labore tempore quo placeat impedit est eaque ad nobis
              quibusdam esse id. Lorem ipsum dolor sit amet consectetur
              adipisicing elit. Blanditiis dolores ducimus reiciendis
              reprehenderit temporibus iure quaerat placeat assumenda natus
              officiis error quam, recusandae molestias ratione consectetur
              alias quia voluptatem ipsum!
            </div>
            <div>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum,
              expedita obcaecati? Rem nobis, porro, maxime deserunt saepe quas
              aliquam suscipit excepturi placeat nesciunt amet laboriosam sit
              architecto illum aspernatur non!
            </div>
            <div>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum,
              expedita obcaecati? Rem nobis, porro, maxime deserunt saepe quas
              aliquam suscipit excepturi placeat nesciunt amet laboriosam sit
              architecto illum aspernatur non!
            </div>
            <div>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum,
              expedita obcaecati? Rem nobis, porro, maxime deserunt saepe quas
              aliquam suscipit excepturi placeat nesciunt amet laboriosam sit
              architecto illum aspernatur non! Lorem ipsum dolor sit amet
              consectetur adipisicing elit. Consequatur pariatur consectetur
              corporis, molestiae fugit sed, dolorum, beatae dignissimos nemo
              error provident dicta asperiores magnam sunt eaque vitae ipsa
              voluptatum animi.
            </div>
            <div>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum,
              expedita obcaecati? Rem nobis, porro, maxime deserunt saepe quas
              aliquam suscipit excepturi placeat nesciunt amet laboriosam sit
              architecto illum aspernatur non!
            </div>
            <div>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum,
              expedita obcaecati? Rem nobis, porro, maxime deserunt saepe quas
              aliquam suscipit excepturi placeat nesciunt amet laboriosam sit
              architecto illum aspernatur non! Lorem ipsum dolor sit amet
              consectetur adipisicing elit. Natus quia aliquam, ad voluptas
              sequi perferendis quam sint est architecto? Facilis itaque nulla
              sequi nisi autem! Quas vero deserunt quibusdam magnam? Lorem ipsum
              dolor sit amet consectetur, adipisicing elit. Cumque tenetur
              exercitationem voluptate esse id? Explicabo mollitia voluptatem,
              eius labore tempore quo placeat impedit est eaque ad nobis
              quibusdam esse id. Lorem ipsum dolor sit amet consectetur
              adipisicing elit. Blanditiis dolores ducimus reiciendis
              reprehenderit temporibus iure quaerat placeat assumenda natus
              officiis error quam, recusandae molestias ratione consectetur
              alias quia voluptatem ipsum!
            </div>
            <div>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum,
              expedita obcaecati? Rem nobis, porro, maxime deserunt saepe quas
              aliquam suscipit excepturi placeat nesciunt amet laboriosam sit
              architecto illum aspernatur non!
            </div>
            <div>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum,
              expedita obcaecati? Rem nobis, porro, maxime deserunt saepe quas
              aliquam suscipit excepturi placeat nesciunt amet laboriosam sit
              architecto illum aspernatur non!
            </div>
            <div>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum,
              expedita obcaecati? Rem nobis, porro, maxime deserunt saepe quas
              aliquam suscipit excepturi placeat nesciunt amet laboriosam sit
              architecto illum aspernatur non! Lorem ipsum dolor sit amet
              consectetur adipisicing elit. Natus quia aliquam, ad voluptas
              sequi perferendis quam sint est architecto? Facilis itaque nulla
              sequi nisi autem! Quas vero deserunt quibusdam magnam? Lorem ipsum
              dolor sit amet consectetur, adipisicing elit. Cumque tenetur
              exercitationem voluptate esse id? Explicabo mollitia voluptatem,
              eius labore tempore quo placeat impedit est eaque ad nobis
              quibusdam esse id. Lorem ipsum dolor sit amet consectetur
              adipisicing elit. Blanditiis dolores ducimus reiciendis
              reprehenderit temporibus iure quaerat placeat assumenda natus
              officiis error quam, recusandae molestias ratione consectetur
              alias quia voluptatem ipsum!
            </div>
          </div>
          <div className="w-75 d-flex pt-3 justify-content-between">
            <div>
              <Image
                src={previousIcon}
                alt="Previous"
                width={20}
                height={20}
              ></Image>
              <Link href={"this-is-previous-blog"}>this-is-previous-blog</Link>
            </div>
            <div>
              <Link href={"this-is-next-blog"}>this-is-next-blog</Link>
              <Image
                src={forwardIcon}
                alt="Next"
                width={20}
                height={20}
              ></Image>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}
